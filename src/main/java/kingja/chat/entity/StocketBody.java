package kingja.chat.entity;

/**
 * Description:TODO
 * Create Time:2019/11/5 0005 下午 2:28
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class StocketBody {
    /*指纹*/
    private String fingerprint;
    /*内容*/
    private String content;
    /*是否是创建者 0 否 1 是*/
    private int isAdmin;
    /*是否是自己*/
    private int isMyself;
    /*1 消息体 2 警告*/
    private int orderType;

    public StocketBody() {
    }

    public StocketBody(int orderType, String content) {
        this.orderType = orderType;
        this.content = content;
    }

    public int getIsMyself() {
        return isMyself;
    }

    public void setIsMyself(int isMyself) {
        this.isMyself = isMyself;
    }

    public String getFingerprint() {
        return null == fingerprint ? "" : fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getContent() {
        return null == content ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }
}
