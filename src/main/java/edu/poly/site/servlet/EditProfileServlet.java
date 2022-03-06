package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.comon.PageInfo;
import edu.poly.comon.PageType;
import edu.poly.comon.SesstionUtils;
import edu.poly.dao.UserDao;
import entyti.User;

@WebServlet("/EditProfile")
public class EditProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = SesstionUtils.getLoginedUsername(request);
		if (id == null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}
		try {
			UserDao dao = new UserDao();
			User user = dao.findById(id);

			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwordSite(request, response, PageType.SITE_EDIT_PROFILE_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = SesstionUtils.getLoginedUsername(request);
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			
			UserDao dao = new UserDao();
			User oldUser = dao.findById(id);
			
			user.setAdmins(oldUser.isAdmins());
			dao.update(user);
			
			request.setAttribute("message", "Cập nhật thành công !");
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwordSite(request, response, PageType.SITE_EDIT_PROFILE_PAGE);
	}

}
