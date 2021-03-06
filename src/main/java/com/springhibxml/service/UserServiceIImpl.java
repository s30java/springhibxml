package com.springhibxml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springhibxml.dao.UserDao;
import com.springhibxml.model.UserModel;




@Service
@Transactional
public class UserServiceIImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public void addUser(UserModel user) {
		
		userDao.saveUser(user);
	}

	public List<UserModel> getUser() {

		List<UserModel> getusers=userDao.getUser();                                     
		return getusers;
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

	@Override
	public UserModel getUser(int id) {
		UserModel userModel=userDao.getUser(id);
		return userModel;
	}

	@Override
	public void updateUser(UserModel user) {
		userDao.updateUser(user);
		
	}

}
