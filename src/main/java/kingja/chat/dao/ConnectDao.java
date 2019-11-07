package kingja.chat.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kingja.chat.dto.DConnect;

/**
 * Description:TODO
 * Create Time:2019/9/3 0003 下午 3:44
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Mapper
public interface ConnectDao {

    @Insert("insert into connect(id,connectId,adminFp,adminCode,password,needLimitCount,maxCount,needCheck)values(#{id}," +
            "#{connectId},#{adminFp},#{adminCode},#{password},#{needLimitCount},#{maxCount},#{needCheck})")
    int create(@Param("id") String id, @Param("connectId") String connectId, @Param("adminFp") String adminFp,
               @Param("adminCode") String adminCode, @Param("password") String password,
               @Param("needLimitCount") int needLimitCount,@Param("maxCount") int maxCount, @Param("needCheck") int needCheck);

    @Select("Select connectId,adminCode,adminFp,password,maxCount,needCheck From connect Where connectId=#{connectId}")
    DConnect getConnectById(String connectId);
}
