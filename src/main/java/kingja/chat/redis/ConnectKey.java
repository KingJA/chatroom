package kingja.chat.redis;

/**
 * Description:TODO
 * Create Time:2019/9/4 0004 下午 5:21
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ConnectKey extends BasePrefix {


    public ConnectKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    public static ConnectKey ConnectId = new ConnectKey(60*5, "ConnectId ");
}
