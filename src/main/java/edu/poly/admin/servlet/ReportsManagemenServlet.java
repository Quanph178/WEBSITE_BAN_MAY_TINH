package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.comon.PageInfo;
import edu.poly.comon.PageType;
import edu.poly.dao.FavoriteDao;
import edu.poly.domain.FavoriteReport;

@WebServlet("/ReportsManagemenServlet")
public class ReportsManagemenServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reportFavoriteByVideos(request, response);
		PageInfo.prepareAndForword(request, response, PageType.REPORTS_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	protected void reportFavoriteByVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			FavoriteDao dao = new FavoriteDao();
			List<FavoriteReport> list = dao.reportFavoriteByVideo();
			
			request.setAttribute("favList", list);
		} catch (Exception e) {
			request.setAttribute("error", "Error:" +e.getMessage());
		}
	}

}
