package kingja.chat.dto;

/**
 * Description:TODO
 * Create Time:2019/11/4 0004 上午 11:47
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class DConnect {
    private String connectId;
    private String adminId;
    private String password;
    private int maxCount;
    private short needCheck;

    public String getAdminId() {
        return null == adminId ? "" : adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getConnectId() {
        return null == connectId ? "" : connectId;
    }

    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    public String getPassword() {
        return null == password ? "" : password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", adminId='" + adminId + '\'' +
                ", password='" + password + '\'' +
                ", maxCount=" + maxCount +
                ", needCheck=" + needCheck +
                '}';
    }
}
