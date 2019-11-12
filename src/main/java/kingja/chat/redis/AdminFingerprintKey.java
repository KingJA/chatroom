package kingja.chat.redis;

/**
 * Description:TODO
 * Create Time:2019/9/4 0004 下午 5:21
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class AdminFingerprintKey extends BasePrefix {

    public AdminFingerprintKey(String prefix) {
        super( prefix);
    }


    public static AdminFingerprintKey AdminFingerprint=new AdminFingerprintKey("AdminFingerprint");
}
