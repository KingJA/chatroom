package kingja.chat.form;

/**
 * Description:TODO
 * Create Time:2019/10/11 0011 下午 4:39
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FormRegister {
    private String username;
    private String password;

    public String getUsername() {
        return null == username ? "" : username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return null == password ? "" : password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
