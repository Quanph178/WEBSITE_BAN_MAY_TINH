package edu.poly.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.comon.EmailUtils;
import edu.poly.comon.PageInfo;
import edu.poly.comon.PageType;
import edu.poly.dao.UserDao;
import edu.poly.domain.Email;
import entyti.User;

@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageInfo.prepareAndForwordSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String emailAdddress =request.getParameter("email");
			String id = request.getParameter("id");
			UserDao dao = new UserDao();
			User user  = dao.findByUsernameAndEmail(id, emailAdddress); 
			if(user ==null) {
				request.setAttribute("error", "Username hoac email khong dung");
				
			}else {
				Email email = new Email();
				email.setFrom("quaanins@gmail.com");
				email.setFromPassword("Quanyen1805");
				email.setTo(emailAdddress);
				email.setSubject("Forgot Password Function");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear").append(id ).append("<br>");
				sb.append("You are used the forgot password function. <br>");
				sb.append("Your password is <b>").append(user.getPasswords()).append("</b>");
				sb.append("Regards<br>");
				sb.append("Administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				request.setAttribute("message", "Email sent to the email Address."+"Please check end get your password");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
	}

}
