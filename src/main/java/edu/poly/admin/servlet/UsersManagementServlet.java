package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.comon.PageInfo;
import edu.poly.comon.PageType;
import edu.poly.dao.UserDao;
import entyti.User;

@WebServlet({ "/Admin/UsersManagementServlet", "/Admin/UsersManagementServlet/create",
		"/Admin/UsersManagementServlet/update", "/Admin/UsersManagementServlet/delete",
		"/Admin/UsersManagementServlet/reset", "/Admin/UsersManagementServlet/edit" })
@MultipartConfig
public class UsersManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		findAll(request, response);
		String url = request.getRequestURL().toString();
		if (url.contains("edit")) {
			edit(request, response);
			return;
		}

		if (url.contains("delete")) {
			delete(request, response);
			return;
		}
		if (url.contains("reset")) {
			reset(request, response);
			return;
		}

		User user = new User();

		findAll(request, response);

		request.setAttribute("user", user);
		PageInfo.prepareAndForword(request, response, PageType.USERS_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		findAll(request, response);
		String url = request.getRequestURL().toString();
		if (url.contains("create")) {
			create(request, response);
			return;
		}
		if (url.contains("delete")) {
			delete(request, response);
			return;
		}
		if (url.contains("update")) {
			update(request, response);
			return;
		}
		if (url.contains("reset")) {
			reset(request, response);
			return;
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {

			BeanUtils.populate(user, request.getParameterMap());
			UserDao dao = new UserDao();
			User oldUser = dao.findById(user.getId());

			dao.update(user);

			request.setAttribute("user", user);
			request.setAttribute("message", "Đã cập nhật tài khoản!");
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error:" + e.getMessage());
		}
		PageInfo.prepareAndForword(request, response, PageType.USERS_MANAGEMENT_PAGE);
		
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			UserDao dao = new UserDao();
			User checkUser = dao.findById(user.getId());
			if(checkUser !=null) {
				request.setAttribute("error", "Tài khoản đã tồn tại !");
				PageInfo.prepareAndForword(request, response, PageType.USERS_MANAGEMENT_PAGE);
			}
			dao.insert(user);
			request.setAttribute("user", user);
			request.setAttribute("message", "Đã thêm tài khoản!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Thêm thất bại!" + e.getMessage());
		}
		findAll(request, response);
		PageInfo.prepareAndForword(request, response, PageType.USERS_MANAGEMENT_PAGE);
		
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		request.setAttribute("user", user);
		findAll(request, response);
		PageInfo.prepareAndForword(request, response, PageType.USERS_MANAGEMENT_PAGE);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id == null) {

			request.setAttribute("error", "Tài khoản không được tìm thấy!");
			PageInfo.prepareAndForword(request, response, PageType.USERS_MANAGEMENT_PAGE);
			return;

		}
		try {
			UserDao dao = new UserDao();
			User user = dao.findById(id);

			if (user == null) {
				request.setAttribute("error", "Tài khoản không được tìm thấy!");
				PageInfo.prepareAndForword(request, response, PageType.USERS_MANAGEMENT_PAGE);
				return;
			}
			dao.delete(id);
			request.setAttribute("message", "Đã xoá tài khoản!");
			request.setAttribute("user", new User());
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error:" + e.getMessage());
		}
		PageInfo.prepareAndForword(request, response, PageType.USERS_MANAGEMENT_PAGE);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			request.setAttribute("error", "Video is required!");
			PageInfo.prepareAndForword(request, response, PageType.USERS_MANAGEMENT_PAGE);
			return;
		}
		try {
			UserDao dao = new UserDao();
			User user = dao.findById(id);

			request.setAttribute("user", user);
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error:" + e.getMessage());
		}

		PageInfo.prepareAndForword(request, response, PageType.USERS_MANAGEMENT_PAGE);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		try {

			UserDao dao = new UserDao();
			List<User> list = dao.findAll();
			request.setAttribute("users", list);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error:" + e.getMessage());
		}
	}
}
