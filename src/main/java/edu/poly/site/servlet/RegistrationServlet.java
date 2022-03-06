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
import edu.poly.dao.UserDao;
import entyti.User;


@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.prepareAndForwordSite(request, response, PageType.SITE_REGISTRATION_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			
			BeanUtils.populate(user, request.getParameterMap());
			
			UserDao dao = new UserDao();
			User checkUser = dao.findById(user.getId());
			if(checkUser !=null) {
				request.setAttribute("error", "Tài khoản đã tồn tại !");
				PageInfo.prepareAndForwordSite(request, response, PageType.SITE_REGISTRATION_PAGE);
			}
			dao.insert(user);
			response.sendRedirect(request.getContextPath()+"/Login");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
		PageInfo.prepareAndForwordSite(request, response, PageType.SITE_REGISTRATION_PAGE);
	}

}
