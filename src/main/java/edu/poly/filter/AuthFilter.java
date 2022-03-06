package edu.poly.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.comon.PageInfo;
import edu.poly.comon.PageType;
import edu.poly.comon.SesstionUtils;

@WebFilter({ "/Admin/VideosManagement", "/Homepage", "/Registration", "/DetailServlet", "/ChangePassword",
		"/EditProfile", "/FavoriteServlet", "/Logoff", "/ShareServlet", "/ReportsManagemenServlet",
		"/Admin/VideosManagement/*", "/Admin/UsersManagementServlet/*" })
public class AuthFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		if (SesstionUtils.isLogin(request) == false) {
			PageInfo.prepareAndForwordSite(request, response, PageType.SITE_LOGIN_PAGE);
		}
		request.setAttribute("isLogin", SesstionUtils.isLogin((HttpServletRequest) request));
		chain.doFilter(request, response);
	}

}
