package kingja.chat.service;

import com.google.gson.Gson;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import kingja.chat.dao.ConnectDao;
import kingja.chat.dto.DConnect;
import kingja.chat.exception.ResultException;
import kingja.chat.form.FormConnect;
import kingja.chat.form.FormCreate;
import kingja.chat.jwt.JwtUtil;
import kingja.chat.jwt.Token;
import kingja.chat.result.CodeMsg;
import kingja.chat.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Description:TODO
 * Create Time:2019/10/12 0012 下午 2:21
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Service
@Slf4j
public class ConnectService {

    public static final int MAX_COUNT = 20;
    public static final int MIN_COUNT = 2;
    public static final int DEFAULT_COUNT = 20;

    @Autowired
    ConnectDao connectDao;


    public void create(FormCreate formCreate) {
        //1.判断该用户是否拥有创建权限
        //2.判断该用户创建的连接数是否有余量
        //3.开始创建连接
        boolean needLimitCount = formCreate.isNeedLimitCount();
        int maxCount = formCreate.getMaxCount();
        int count;
        if (needLimitCount) {
            if (maxCount < MIN_COUNT || maxCount > MAX_COUNT) {
                throw new ResultException(CodeMsg.CONNECT_COUNT_ERROR);
            }
        }
        count = connectDao.create(UuidUtil.uuid(), UuidUtil.uuid(), formCreate.getFingerprint(),
                formCreate.getPassword(),
                needLimitCount ? maxCount : DEFAULT_COUNT, formCreate.isNeedCheck() ? 1 : 0);
        if (count == 0) {
            throw new ResultException(CodeMsg.CONNECT_CREATE_ERROR);
        }
    }

    public void connect(FormConnect formConnect, HttpServletResponse response) {
        String connectId = formConnect.getConnectId();
        //获取连接号信息
        DConnect connectInfo = connectDao.getConnectById(connectId);
        if (connectInfo == null) {
            throw new ResultException(CodeMsg.CONNECT_CONNECTID_ERROR);
        }
        log.info("connectInfo : " + connectInfo.toString());
        //连接数是否已超

        //是否有连接密码
        String inputPassword = formConnect.getPassword();
        String dbPassword = connectInfo.getPassword();
        if (!StringUtils.isEmpty(dbPassword)) {
            if (StringUtils.isEmpty(inputPassword)) {
                throw new ResultException(CodeMsg.CONNECT_NEEDPASSWORD_ERROR);
            }
            if (!dbPassword.equals(inputPassword)) {
                throw new ResultException(CodeMsg.CONNECT_WRONGPASSWORD_ERROR);
            }
        }
        //加入连接
        /**
         * 1.将token写入cookie
         * 2.将token存入redis
         */
        Token token = new Token();
        token.setFingerPrint(formConnect.getFingerprint());
        token.setFingerPrint(connectInfo.getConnectId());
        token.setFingerPrint(connectInfo.getAdminId());

        String jwt = JwtUtil.createJWT(formConnect.getFingerprint(), new Gson().toJson(token), JwtUtil.TTLMILLS);
        Cookie cookie = new Cookie(JwtUtil.TOKEN_NAME, jwt);
        cookie.setPath("/");
        cookie.setMaxAge(JwtUtil.TTLMILLS);
        response.addCookie(cookie);
//        log.info("加入cookie成功:" + jwt);

    }
}
