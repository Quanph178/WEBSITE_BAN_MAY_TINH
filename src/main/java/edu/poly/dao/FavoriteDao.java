package edu.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entyti.Favorite;
import edu.poly.domain.FavoriteReport;
public class FavoriteDao extends AbstractEntityDao<Favorite> {

	public FavoriteDao() {
		super(Favorite.class);
		// TODO Auto-generated constructor stub
	}

	public List<FavoriteReport> reportFavoriteByVideo() {
		String jpql = "select edu.poly.domain.FavoriteReport(f.video.title,coutn(f), min(f.likeDate), max(f.likeDate) "
				+ " from Favorite f group by  f.video.title ";
		EntityManager em = JpaUtils.getEntityManager();
		List<FavoriteReport> list = null;
		try {
			TypedQuery<FavoriteReport> query = em.createQuery(jpql, FavoriteReport.class);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}

}
