package kingja.chat.entity;

/**
 * Description:TODO
 * Create Time:2019/10/12 0012 下午 5:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class User {
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
