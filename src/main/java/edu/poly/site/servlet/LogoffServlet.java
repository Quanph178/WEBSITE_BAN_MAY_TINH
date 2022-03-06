package edu.poly.site.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.comon.CookieUtils;
import edu.poly.comon.SesstionUtils;
import edu.poly.dao.UserDao;
import edu.poly.domain.LoginForm;
import entyti.User;

@WebServlet("/Logoff")
public class LogoffServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		;
		CookieUtils.add("id", null, 0, response);
		SesstionUtils.invalidate(request);
		request.setAttribute("isLogin", false);
		request.getRequestDispatcher("/Login").forward(request, response);
	}

}
