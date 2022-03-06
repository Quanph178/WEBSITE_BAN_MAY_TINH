package edu.poly.site.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.comon.SesstionUtils;
import edu.poly.dao.FavoriteDao;
import entyti.Favorite;
import entyti.User;
import entyti.Video;


@WebServlet("/LikeServlet")
public class LikeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!SesstionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}
		String page = request.getParameter("page");
		String videoid = request.getParameter("id");
		if(videoid == null) {
			response.sendRedirect("/Homepage");
			return;
		}
		try {
			FavoriteDao dao= new FavoriteDao();
			Favorite favorite = new Favorite();
			Video video = new Video();
			video.setId(videoid);
			favorite.setVideo(video);
			
			String id = SesstionUtils.getLoginedUsername(request);
			User user = new User();
			user.setId(id);
			favorite.setUser(user);
			
			favorite.setLikeDate(new Date());
			dao.insert(favorite);
			
			request.setAttribute("message", "Video is added to Favorite");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		if(page ==null) {
			 page = "/Homepage";
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
