package edu.poly.domain;

import java.util.Date;

public class FavoriteReport {
	private String videoTitle;
	private Long favoriteCount;
	private Date newesDate;
	private Date olesDate;

	public FavoriteReport() {
		super();
	}

	public FavoriteReport(String videoTitle, Long favoriteCount, Date newesDate, Date olesDate) {
		super();
		this.videoTitle = videoTitle;
		this.favoriteCount = favoriteCount;
		this.newesDate = newesDate;
		this.olesDate = olesDate;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public Long getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(Long favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public Date getNewesDate() {
		return newesDate;
	}

	public void setNewesDate(Date newesDate) {
		this.newesDate = newesDate;
	}

	public Date getOlesDate() {
		return olesDate;
	}

	public void setOlesDate(Date olesDate) {
		this.olesDate = olesDate;
	}

}
