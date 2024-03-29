package kingja.chat.websocket;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.annotation.PostConstruct;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import kingja.chat.entity.SocketBody;
import kingja.chat.redis.AdminFingerprintKey;
import kingja.chat.redis.ConnectKey;
import kingja.chat.redis.RedisService;
import lombok.extern.slf4j.Slf4j;

/**
 * Description:TODO
 * Create Time:2019/10/11 0011 上午 8:48
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */


/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 *  * 使用springboot的唯一区别是要@Component声明下，而使用独立容器是由容器自己管理websocket的，
 *  * 但在springboot中连容器都是spring管理的。
 *  虽然@Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，
 *  所以可以用一个静态set保存起来。
 */
@ServerEndpoint("/websocket/{connectId}/{fingerprint}/{adminCode}")
@Component
@Slf4j
public class WebSocketListener {

    public static WebSocketListener listener;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<WebSocketListener> webSocketSet = new CopyOnWriteArraySet<WebSocketListener>();

    //存放<连接号,WebStocket客户端列表>
    private static ConcurrentHashMap<String, ConcurrentHashMap<String, Session>> webSocketSessionMap =
            new ConcurrentHashMap<>();
    private static final String NORMAL_ADMINCODE = "000000";


    @PostConstruct
    public void init() {
        listener = this;
        listener.redisService = this.redisService;
    }

    @Autowired
    RedisService redisService;

    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("connectId") String connectId,
                       @PathParam("fingerprint") String fingerprint, @PathParam("adminCode") String adminCode) {
        /**
         * adminCode不为空
         * 1.真实验证码
         * 2.undefined
         * adminCode为空
         */
        //1.adminCode为000000，则是普通用户，则不作任何操作

        //2.保存connectId,fingerprint,保存管理员
        if (!NORMAL_ADMINCODE.equals(adminCode)) {
            String adminFingerprint = listener.redisService.get(AdminFingerprintKey.AdminFingerprint, connectId, String.class);
            if (adminFingerprint == null) {
                listener.redisService.set(AdminFingerprintKey.AdminFingerprint,connectId,fingerprint);
            }else{
                session.getAsyncRemote().sendText(new Gson().toJson(new SocketBody(3, "已有用户使用相同标识码连接")));
            }
        }
        ConcurrentHashMap<String, Session> connnectIdMap = webSocketSessionMap.get(connectId);
        if (connnectIdMap == null) {
            connnectIdMap = new ConcurrentHashMap<>();
        }
        if (connnectIdMap.containsKey(fingerprint)) {
            //已经加入连接
            session.getAsyncRemote().sendText(new Gson().toJson(new SocketBody(2, "请勿重复加入连接")));
        } else {
            connnectIdMap.put(fingerprint, session);
            webSocketSessionMap.put(connectId, connnectIdMap);
            listener.redisService.incr(ConnectKey.ConnectId, connectId);
            log.info(String.format((!"undefined".equals(adminCode) ? "群主" : "用户") + "加入，当前连接号%s的连接数:%d", connectId,
                    listener.redisService.get(ConnectKey.ConnectId
                    , connectId, Integer.class)));
        }

        /**
         * 用户使用jwt进行连接，参数包括connectId，fingerprint,群主Id
         */

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session, @PathParam("connectId") String connectId,
                        @PathParam("fingerprint") String fingerprint, @PathParam("adminCode") String adminCode) {

        ConcurrentHashMap<String, Session> connnectIdMap = webSocketSessionMap.get(connectId);
        if (connnectIdMap != null && connnectIdMap.containsKey(fingerprint) && connnectIdMap.get(fingerprint).getId().equals(session.getId())) {
            log.info("离开，remove");
            connnectIdMap.remove(fingerprint);
            listener.redisService.decr(ConnectKey.ConnectId, connectId);
        }
        log.info(String.format((!"undefined".equals(adminCode) ? "群主" : "用户") + "离开，当前连接号%s的连接数:%d", connectId,
                listener.redisService.get(ConnectKey.ConnectId
                , connectId, Integer.class)));
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("connectId") String connectId,
                          @PathParam("fingerprint") String fingerprint, @PathParam("adminCode") String adminCode) {
        log.info(String.format((!"undefined".equals(adminCode) ? "群主" : "用户") + "连接号%s的%s发来消息:%s", connectId,
                fingerprint, message));
        ConcurrentHashMap<String, Session> connnectIdMap = webSocketSessionMap.get(connectId);
        for (String key : connnectIdMap.keySet()) {
            Session item = connnectIdMap.get(key);
            SocketBody stocketBody = new SocketBody();
            stocketBody.setFingerprint(fingerprint);
            stocketBody.setContent(message);
            String adminFingerprint = listener.redisService.get(AdminFingerprintKey.AdminFingerprint, connectId, String.class);
            stocketBody.setIsAdmin(fingerprint.equals(adminFingerprint)?1:0);
            stocketBody.setIsMyself(session.getId().equals(item.getId()) ? 1 : 0);
            stocketBody.setOrderType(1);
            try {
                item.getAsyncRemote().sendText(new Gson().toJson(stocketBody));
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

}