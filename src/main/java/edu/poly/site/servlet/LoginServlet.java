package edu.poly.site.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.comon.CookieUtils;
import edu.poly.comon.PageInfo;
import edu.poly.comon.PageType;
import edu.poly.comon.SesstionUtils;
import edu.poly.dao.UserDao;
import edu.poly.domain.LoginForm;
import entyti.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = CookieUtils.get("id", request);
		if (id == null) {
			PageInfo.prepareAndForwordSite(request, response, PageType.SITE_LOGIN_PAGE);
		}
		SesstionUtils.add(request, "id", id);
		request.getRequestDispatcher("/Homepage").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LoginForm form = new LoginForm();

			BeanUtils.populate(form, request.getParameterMap());

			UserDao dao = new UserDao();
			User user = dao.findById(form.getId());
			if (user != null && user.getPasswords().equals(form.getPasswords())) {
				SesstionUtils.add(request, "id", user.getId());
				if (form.isRemember()) {
					CookieUtils.add("id", form.getId(), 24, response);
				} else {
					CookieUtils.add("id", form.getId(), 0, response);
				}
				if(user.isAdmins()) {
					PageInfo.prepareAndForword(request, response, PageType.VIDEO_MAMAGEMENT_PAGE);
				}
				request.setAttribute("isLogin", true);
				request.setAttribute("name", user.getFullname());
				response.sendRedirect(request.getContextPath()+"/Homepage");

				return;
			}
			request.setAttribute("error", "Username và password không hợp lệ");

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwordSite(request, response, PageType.SITE_LOGIN_PAGE);
	}

}
