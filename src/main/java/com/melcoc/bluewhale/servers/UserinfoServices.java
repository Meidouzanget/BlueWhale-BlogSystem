package com.melcoc.bluewhale.servers;

import com.melcoc.bluewhale.domain.Userinfo;

public interface UserinfoServices {
	//注册
	int reg(Userinfo userinfo);

	//获取密码
	String login(String password);

	//获取用户名
	String getUname(String uname);

	//获取真实姓名
	String getUsealname(String usealname);

	//根据用户真实姓名获取用户密码
	String getPasswordByUsealname(String password);


}
