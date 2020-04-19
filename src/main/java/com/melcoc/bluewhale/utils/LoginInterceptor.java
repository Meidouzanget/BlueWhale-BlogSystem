package com.melcoc.bluewhale.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {


		HttpSession session = request.getSession();
		String u_name = request.getParameter("uname");
		String username =String.valueOf(session.getAttribute("username"));
		session.removeAttribute("uname");
		System.out.println(username);

		if(username.equals("null"))
		{
			//未登录
			System.out.println("对不起！你还没有登录");
			request.getRequestDispatcher("/Userinfo/login").forward(request, response);
			return false;
		}else
		{
			//已经登录了
			return true;
		}



	}
	
}
