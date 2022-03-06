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
import edu.poly.comon.UploadUtitls;
import edu.poly.dao.VideoDao;
import entyti.Video;

@WebServlet({ "/Admin/VideosManagement", "/Admin/VideosManagement/create", "/Admin/VideosManagement/update",
		"/Admin/VideosManagement/delete", "/Admin/VideosManagement/reset", "/Admin/VideosManagement/edit" })
@MultipartConfig

public class VideosManagementServlet extends HttpServlet {

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

		Video video = new Video();

		video.setPoster("image/deasktop.jpg");
		findAll(request, response);

		request.setAttribute("video", video);
		PageInfo.prepareAndForword(request, response, PageType.VIDEO_MAMAGEMENT_PAGE);
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

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			VideoDao dao = new VideoDao();
			video.setPoster("uploads/" + UploadUtitls.processUploadFiled("cover", request, "/uploads", video.getId()));

			dao.insert(video);
			request.setAttribute("video", video);
			request.setAttribute("message", "Đã thêm video!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Thêm video thất bại!" + e.getMessage());
		}
		findAll(request, response);
		PageInfo.prepareAndForword(request, response, PageType.VIDEO_MAMAGEMENT_PAGE);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		try {

			BeanUtils.populate(video, request.getParameterMap());
			VideoDao dao = new VideoDao();
			Video oldVideo = dao.findById(video.getId());

			if (request.getPart("cover").getSize() == 0) {
				video.setPoster(oldVideo.getPoster());
			} else {
				video.setPoster(
						"uploads/" + UploadUtitls.processUploadFiled("cover", request, "/uploads", video.getId()));
			}
			dao.update(video);

			request.setAttribute("video", video);
			request.setAttribute("message", "Đã cập nhật video!");
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error:" + e.getMessage());
		}
		PageInfo.prepareAndForword(request, response, PageType.VIDEO_MAMAGEMENT_PAGE);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		Video video = new Video();
		try {

			VideoDao dao = new VideoDao();
			List<Video> list = dao.findAll();
			request.setAttribute("videos", list);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error:" + e.getMessage());
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			request.setAttribute("error", "Video is required!");
			PageInfo.prepareAndForword(request, response, PageType.VIDEO_MAMAGEMENT_PAGE);
			return;
		}
		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findById(id);

			request.setAttribute("video", video);
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error:" + e.getMessage());
		}

		PageInfo.prepareAndForword(request, response, PageType.VIDEO_MAMAGEMENT_PAGE);
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Video video = new Video();
		video.setPoster("./image/desktop.jpg");
		request.setAttribute("video", video);
		findAll(request, response);
		PageInfo.prepareAndForword(request, response, PageType.VIDEO_MAMAGEMENT_PAGE);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id == null) {

			request.setAttribute("error", "Video không được tìm thấy!");
			PageInfo.prepareAndForword(request, response, PageType.VIDEO_MAMAGEMENT_PAGE);
			return;

		}
		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findById(id);

			if (video == null) {
				request.setAttribute("error", "Video không được tìm thấy!");
				PageInfo.prepareAndForword(request, response, PageType.VIDEO_MAMAGEMENT_PAGE);
				return;
			}
			dao.delete(id);
			request.setAttribute("message", "Đã xoá video!");
			request.setAttribute("video", new Video());
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error:" + e.getMessage());
		}
		PageInfo.prepareAndForword(request, response, PageType.VIDEO_MAMAGEMENT_PAGE);

	}

}
