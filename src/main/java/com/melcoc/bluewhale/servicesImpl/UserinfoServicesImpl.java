package com.melcoc.bluewhale.servicesImpl;

import com.melcoc.bluewhale.dao.UserinfoMapper;
import com.melcoc.bluewhale.domain.Userinfo;
import com.melcoc.bluewhale.servers.UserinfoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userinfoServices")
public class UserinfoServicesImpl implements UserinfoServices {

	@Autowired
	private UserinfoMapper userinfoDao;

	@Override
	public int reg(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return userinfoDao.insert(userinfo);
	}

	@Override
	public String login(String password) {
		// TODO Auto-generated method stub
		return userinfoDao.getPassword(password);
	}

	//获取真实姓名
	@Override
	public String getUsealname(String usealname) {
		// TODO Auto-generated method stub
		return userinfoDao.getUsealname(usealname);
	}


	//获取用户名
	@Override
	public String getUname(String uname) {
		// TODO Auto-generated method stub
		return userinfoDao.getUname(uname);
	}


	//根据用户真实姓名获取用户密码
	@Override
	public String getPasswordByUsealname(String password) {
		// TODO Auto-generated method stub
		return userinfoDao.getPasswordByUsealname(password);
	}


}
