package kingja.chat.vo;

/**
 * Description:TODO
 * Create Time:2019/11/6 0006 下午 3:49
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ConnectInfo {
    private String connectId;
    private String adminCode;
    private String password;
    private int needLimitCount;
    private int maxCount;
    private int needCheck;

    public String getConnectId() {
        return null == connectId ? "" : connectId;
    }

    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    public String getAdminCode() {
        return null == adminCode ? "" : adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getPassword() {
        return null == password ? "" : password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNeedLimitCount() {
        return needLimitCount;
    }

    public void setNeedLimitCount(int needLimitCount) {
        this.needLimitCount = needLimitCount;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getNeedCheck() {
        return needCheck;
    }

    public void setNeedCheck(int needCheck) {
        this.needCheck = needCheck;
    }
}
