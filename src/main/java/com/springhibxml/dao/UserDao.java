package com.springhibxml.dao;

import java.util.List;

import com.springhibxml.model.UserModel;



public interface UserDao {
	public void saveUser(UserModel user);
	public List<UserModel> getUser();
}