package kingja.chat.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kingja.chat.entity.User;
import kingja.chat.form.FormRegister;

/**
 * Description:TODO
 * Create Time:2019/9/3 0003 下午 3:44
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Mapper
public interface UserDao {
    @Select("select * from user where id = #{id}")
    public User getById(@Param("id") int id);

    @Select("select count(*) from user where username = #{username}")
    public int hasUser(@Param("username") String username);

    @Insert("insert into user(id,username,password)values(#{id},#{username},#{password})")
    int addUser(@Param("id") String id, @Param("username") String username, @Param("password") String password);
}
