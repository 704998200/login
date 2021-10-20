package com.asl.intern.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.asl.intern.login.entity.User;
import com.asl.intern.login.mapper.UserMapper;
import com.asl.intern.login.util.Md5EncryptionUtil;
import com.asl.intern.login.util.SqlSessionFactoryUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(password!=null) {
			password=Md5EncryptionUtil.Encrypt(password);
		}
		SqlSession session = SqlSessionFactoryUtil.getSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.findByAccount(account);
		if (user != null && user.getErrorCount() > 5) {
			request.setAttribute("info", "你的账号输入错误次数过多已被锁定");
		} else {
			if (user != null && password != null && password.equals(user.getPassword())) {
				request.setAttribute("info", "登陆成功");
				userMapper.cleanUserErrorCount(account);
				session.commit();
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			} else {
				userMapper.increaseUserErrorCount(account);
				request.setAttribute("info", "用户输入的用户名或密码错误");
			}
		}
		session.commit();
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
