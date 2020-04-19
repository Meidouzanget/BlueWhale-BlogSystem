package com.melcoc.bluewhale.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.melcoc.bluewhale.domain.Userinfo;
import com.melcoc.bluewhale.servers.UserinfoServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/Userinfo")
public class UserinfoController {

	@Resource
	private UserinfoServices userinfoServices;

	// 注册
	@RequestMapping("/reg")
	public String reg(Model model, Userinfo userinfo) throws Exception {
		System.out.println("进入注册================");
		System.out.println("接收注册表单的值" + userinfo);
		try {
			String tr_uname = userinfo.getUname().trim();
			// 后台获取用户名判断与注册用户是否一致，是的话则注册失败（设定用户名的唯一性）
			String db_name = userinfoServices.getUname(tr_uname);
			String tr_upsw = userinfo.getUpsw().trim();
			String tr_usealname = userinfo.getUsealname().trim();
			System.out.println("前台获取值" + userinfo.getUname() + "\t" + tr_uname + "\t数据库用户：" + db_name);
			if (tr_uname != null && tr_upsw != null && tr_usealname != null && tr_uname != db_name && db_name == null) {
				int i = userinfoServices.reg(userinfo);
				System.out.println("状态码:" + i);
				System.out.println("注册成功！");
				return "login";
			} else if (tr_uname.equals(db_name)) {
				System.out.println("账号[" + db_name + "]已被注册!");
				model.addAttribute("msg", "账号[" + db_name + "]已被注册!");
				return "login";
			} else {
				System.out.println("注册失败！");
				return "login";
			}
		} catch (Exception e) {
			System.out.println("程序发生异常！");
			System.out.println(e);
			return "login";
		}

	}

	// 登录
	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest request, Userinfo userinfo) throws Exception {

		HttpSession session = request.getSession();
		String username = String.valueOf(session.getAttribute("username"));

		System.out.println("接收登录表单的值" + userinfo);
		// 根据用户名从数据查询的密码
		String db_password = userinfoServices.login(userinfo.getUname());
		// 根据用户名从数据查询的真实姓名
		String db_usealname = userinfoServices.getUsealname(userinfo.getUname());
		try {
			if (username.equals("null")) {
				System.out.println("密码" + db_password + "\t真实姓名" + db_usealname);
				if (db_password.equals("") || db_password == null && db_usealname.equals("") || db_usealname == null) {
					System.out.println("用户名不存在！");
					return "login";
				} else {
					if (db_password.equals(userinfo.getUpsw()) && db_usealname.equals(userinfo.getUsealname())) {
						// 登录成功！
						session.setAttribute("username", request.getParameter("uname"));
						System.out.println("登录成功");
						return "index";

					} else {
						// 登录失败！
						System.out.println("用户名或者密码错误！");
						System.out.println("对不起，你输入账号:" + db_password + "用户名或密码错！");
						return "login";
					}
				}
			} else {
				// 已经登录了
				return "index";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("程序发生了异常！");
			System.out.println(e);
			return "login";
		}

	}

	// 退出
	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request, Userinfo userinfo) {
		System.out.println("退出登录");
		HttpSession session = request.getSession();
		String username = String.valueOf(session.getAttribute("username"));
		session.removeAttribute("username");
		return "login";

	}
}
