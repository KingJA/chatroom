package kingja.chat.form;

/**
 * Description:TODO
 * Create Time:2019/11/1 0001 上午 10:01
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FormConnect {
    /*连接指纹*/
    private String fingerprint;
    /*连接号*/
    private String connectId;
    /*连接密码*/
    private String password;

    /*创建者标识码*/
    private String adminCode;

    public String getAdminCode() {
        return null == adminCode ? "" : adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getFingerprint() {
        return null == fingerprint ? "" : fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
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

    @Override
    public String toString() {
        return "FormConnect{" +
                "fingerprint='" + fingerprint + '\'' +
                ", connectId='" + connectId + '\'' +
                ", password='" + password + '\'' +
                ", adminCode='" + adminCode + '\'' +
                '}';
    }
}
