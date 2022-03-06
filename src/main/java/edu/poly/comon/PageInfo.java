package edu.poly.comon;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashedMap();

	static {
		pageRoute.put(PageType.USERS_MANAGEMENT_PAGE, new PageInfo("User Management", "/admin/users/users.jsp", null));

		pageRoute.put(PageType.REPORTS_MANAGEMENT_PAGE, new PageInfo("Report Management", "/admin/reports/reports.jsp", null));

		pageRoute.put(PageType.VIDEO_MAMAGEMENT_PAGE, new PageInfo("Vdeo Management", "/admin/videos/videos.jsp", null));

		pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("Home Page", "/sites/home/home.jsp", null));

		pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("Login Page", "/sites/users/login.jsp", null));

		pageRoute.put(PageType.SITE_REGISTRATION_PAGE, new PageInfo("Registration Page", "/sites/users/registration.jsp", null));

		pageRoute.put(PageType.SITE_CHANGE_PASSWORD_PAGE, new PageInfo("Change Password Page", "/sites/users/change-password.jsp", null));

		pageRoute.put(PageType.SITE_EDIT_PROFILE_PAGE, new PageInfo("Edit Profile Page", "/sites/users/edit-profile.jsp", null));

		pageRoute.put(PageType.SITE_FORGOT_PASSWORD_PAGE, new PageInfo("Forgot Password Page", "/sites/users/forgot-password.jsp", null));

		pageRoute.put(PageType.SITE_VIDEO_DETAIL_PAGE, new PageInfo("Video Detail Page", "/sites/videos/detail.jsp", null));

		pageRoute.put(PageType.SITE_SHARE_PAGE, new PageInfo("Share Page", "/sites/videos/share.jsp", null));

		pageRoute.put(PageType.SITE_FAVORITE_PAGE, new PageInfo("Favorite Page", "/sites/videos/favorite.jsp", null));

	}

	public static void prepareAndForword(HttpServletRequest request, HttpServletResponse response, PageType pageType)
			throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);

		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin/layout.jsp").forward(request, response);
	}

	public static void prepareAndForwordSite(HttpServletRequest request, HttpServletResponse response,
			PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);

		request.setAttribute("page", page);
		request.getRequestDispatcher("/sites/layout.jsp").forward(request, response);
	}

	private String title;
	private String contenUrl;
	private String scriptUrl;

	public PageInfo(String title, String contenUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contenUrl = contenUrl;
		this.scriptUrl = scriptUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContenUrl() {
		return contenUrl;
	}

	public void setContenUrl(String contenUrl) {
		this.contenUrl = contenUrl;
	}

	public String getScriptUrl() {
		return scriptUrl;
	}

	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}

}
