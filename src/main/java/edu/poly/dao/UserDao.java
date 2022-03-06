package edu.poly.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entyti.User;

public class UserDao extends AbstractEntityDao<User> {

	public UserDao() {
		super(User.class);
	}

	public void changePassword(String username, String oldPassword, String newPassword) throws Exception {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		String jpql = "select u from User u where u.id = :id and u.passwords = :passwords ";
		try {
			trans.begin();
			TypedQuery<User> query  =em.createQuery(jpql,User.class);
			query.setParameter("id", username);
			query.setParameter("passwords", oldPassword);
			User user = query.getSingleResult();
			if( user == null ) {
				throw new Exception("Tài khoản và mật khẩu không đúng!");
			}
			user.setPasswords(newPassword);
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw e ;
		}finally {
			em.close();
		}
	}
	public User findByUsernameAndEmail(String username,String email) {
		EntityManager em = JpaUtils.getEntityManager();
		String jsql = "select u from User u where u.id=:id and u.email = :email";
		try {
			TypedQuery<User> query = em.createQuery(jsql,User.class);
			query.setParameter("id", username);
			query.setParameter("email", email);
			
			return query.getSingleResult();
		} finally {
			em.close();
		}
	}
}
