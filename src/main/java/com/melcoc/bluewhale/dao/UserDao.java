package com.melcoc.bluewhale.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.melcoc.bluewhale.domain.LUser;
import com.melcoc.bluewhale.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;




@Mapper
public interface UserDao extends BaseMapper<User> {

    @Update("UPDATE from user SET avatar=#{avatar} WHERE user_id=#{userId}")
    int updateByIduUrl(int userId,String avatar);

    @Select("SELECT COUNT(*) FROM l_user where name=#{username}")
    int RepeatUserNameQuery(@Param("username") String username);

    @Select("SELECT COUNT(*) FROM l_user where account=#{email}")
    int RepeatUserEmailQuery(@Param("email") String email);

    int insert(User user);

    int deleteById(Integer id);

    int updateById(User USer);

    @Select("SELECT * FROM user where name=#{username}")
    User selectByUserName(@Param("username") String username);

    @Select("SELECT * FROM l_user where name=#{username}")
    LUser selectBylUserName(@Param("username") String username);

    /**
     * 修改个人信息
     */
    int updateByIdUser(User user);
    /**
     * 根据UserId修改avatar
     */


    /**
     * 查询用户ID
     */
    @Select("select user_id from user where name=#{name} ")
    int selectUserId(String name);

}
