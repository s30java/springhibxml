/**
 * 
 */
package com.springhibxml.service;

import java.util.List;

import com.springhibxml.model.UserModel;


public interface UserService {

	public void addUser(UserModel user);                      
	public List<UserModel> getUser();
	public void deleteUser(int id);
	public UserModel getUser(int id);
}
