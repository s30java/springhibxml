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


	@Override
	public void deleteUser(int id) {
		UserModel userModel=getUser(id);
		
		if(userModel!=null)
			sessionFactory.getCurrentSession().delete(userModel);
		
	}


	@Override
	public UserModel getUser(int id) {
		UserModel userModel=(UserModel)sessionFactory.getCurrentSession().get(UserModel.class,id);
		
		return userModel;
	}


	@Override
	public void updateUser(UserModel user) {
		
		UserModel userModel=new UserModel();
		userModel.setId(user.getId()); 
		userModel.setFirstName(user.getFirstName());
		userModel.setLastName(user.getLastName());
		userModel.setCity(user.getCity());
		userModel.setGender(user.getGender());
		sessionFactory.getCurrentSession().update(userModel);
		
	}




}
