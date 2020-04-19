package com.melcoc.bluewhale.dao;

import com.melcoc.bluewhale.domain.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



@Repository("userinfoDao")

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer uid);

    //添加用户
    int insert(Userinfo userinfo);

    //获取用户密码
    String getPassword(String password);

    //根据用户真实姓名获取用户密码
    String getPasswordByUsealname(String password);

    //获取用户名
    String getUname(String uname);

    //获取用户真实姓名
    String getUsealname(String usealname);



    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}