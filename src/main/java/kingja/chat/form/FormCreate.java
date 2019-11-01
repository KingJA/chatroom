package kingja.chat.form;

/**
 * Description:TODO
 * Create Time:2019/11/1 0001 上午 10:01
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FormCreate {
    /*连接指纹*/
    private String fingerprint;
    /*连接密码*/
    private String password;
    /*是否限制人数 0否 1是*/
    private boolean needLimitCount;
    /*限制人数 默认2-100*/
    private int maxCount;
    /*是否需要验证 0否 1是*/
    private boolean needCheck;

    public String getFingerprint() {
        return null == fingerprint ? "" : fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getPassword() {
        return null == password ? "" : password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isNeedLimitCount() {
        return needLimitCount;
    }

    public void setNeedLimitCount(boolean needLimitCount) {
        this.needLimitCount = needLimitCount;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public boolean isNeedCheck() {
        return needCheck;
    }

    public void setNeedCheck(boolean needCheck) {
        this.needCheck = needCheck;
    }

    @Override
    public String toString() {
        return "FormCreate{" +
                "fingerprint='" + fingerprint + '\'' +
                ", password='" + password + '\'' +
                ", needLimitCount=" + needLimitCount +
                ", maxCount=" + maxCount +
                ", needCheck=" + needCheck +
                '}';
    }
}
