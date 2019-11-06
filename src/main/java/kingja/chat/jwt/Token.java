package kingja.chat.jwt;

/**
 * Description:TODO
 * Create Time:2019/11/4 0004 下午 3:10
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Token {
    private String connectId;
    private String fingerPrint;
    private String adminFp;

    public String getConnectId() {
        return null == connectId ? "" : connectId;
    }

    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    public String getFingerPrint() {
        return null == fingerPrint ? "" : fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public String getadminFp() {
        return null == adminFp ? "" : adminFp;
    }

    public void setadminFp(String adminFp) {
        this.adminFp = adminFp;
    }

    @Override
    public String toString() {
        return "Token{" +
                "connectId='" + connectId + '\'' +
                ", fingerPrint='" + fingerPrint + '\'' +
                ", adminFp='" + adminFp + '\'' +
                '}';
    }
}
