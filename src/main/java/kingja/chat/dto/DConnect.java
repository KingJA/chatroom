package kingja.chat.dto;

/**
 * Description:TODO
 * Create Time:2019/11/4 0004 上午 11:47
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class DConnect {
    private String connectId;
    private String adminFp;
    private String password;
    private String adminCode;
    private int maxCount;
    private short needCheck;

    public String getConnectId() {
        return null == connectId ? "" : connectId;
    }

    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    public String getAdminFp() {
        return null == adminFp ? "" : adminFp;
    }

    public void setAdminFp(String adminFp) {
        this.adminFp = adminFp;
    }

    public String getPassword() {
        return null == password ? "" : password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminCode() {
        return null == adminCode ? "" : adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public short getNeedCheck() {
        return needCheck;
    }

    public void setNeedCheck(short needCheck) {
        this.needCheck = needCheck;
    }

    @Override
    public String toString() {
        return "DConnect{" +
                "connectId='" + connectId + '\'' +
                ", adminFp='" + adminFp + '\'' +
                ", password='" + password + '\'' +
                ", adminCode='" + adminCode + '\'' +
                ", maxCount=" + maxCount +
                ", needCheck=" + needCheck +
                '}';
    }
}
