/**
 * 
 */
package com.springhibxml.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springhibxml.model.UserModel;




/**
 * @author swaybhase
 *
 */
@Repository("UserDao")
public class UserDaoImpl implements UserDao {             


	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveUser(UserModel user) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}


	@Transactional
	public List<UserModel> getUser() {
		@SuppressWarnings("unchecked")
		List<UserModel> user=sessionFactory.getCurrentSession().createCriteria(UserModel.class).list();
		return user;
	}




}
