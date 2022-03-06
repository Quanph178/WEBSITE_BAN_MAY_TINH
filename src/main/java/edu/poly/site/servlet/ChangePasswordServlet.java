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
import edu.poly.domain.ChangePasswordForm;

@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = SesstionUtils.getLoginedUsername(request);
		if (username == null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}

		request.setAttribute("id", username);
		PageInfo.prepareAndForwordSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = SesstionUtils.getLoginedUsername(request);
			ChangePasswordForm form = new ChangePasswordForm();
			BeanUtils.populate(form, request.getParameterMap());
			request.setAttribute("id", username);

			if (!form.getConfirmPassword().equals(form.getPasswords())) {
				request.setAttribute("error", "Mật khẩu xác nhận chưa đúng");
			} else {
				UserDao dao = new UserDao();
				dao.changePassword(form.getId(), form.getCurrentPassword(), form.getPasswords());
				request.setAttribute("message", "Đổi mật khẩu thành công!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwordSite(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE); 
	}

}
