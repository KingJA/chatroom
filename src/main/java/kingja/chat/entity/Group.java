package kingja.chat.entity;

/**
 * Description:TODO
 * Create Time:2019/10/29 0029 下午 5:20
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Group {

    private String id;
    private String name;
    private String imgUrl;
    private String createTime;
    private String updateTime;

    public String getId() {
        return null == id ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return null == name ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return null == imgUrl ? "" : imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCreateTime() {
        return null == createTime ? "" : createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return null == updateTime ? "" : updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
