package kingja.chat.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Description:TODO
 * Create Time:2019/9/3 0003 下午 3:44
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Mapper
public interface ConnectDao {
    @Insert("insert into connect(id,connectId,adminId,password,maxCount,needCheck)values(#{id},#{connectId},#{adminId},#{password},#{maxCount},#{needCheck})")
    int create(@Param("id") String id, @Param("connectId") String connectId, @Param("adminId") String adminId
            , @Param("password") String password, @Param("maxCount") int maxCount, @Param("needCheck") int needCheck);
}
