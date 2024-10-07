package com.spring.rest.service;

import java.util.List;

import com.spring.rest.model.UserModel;
import com.spring.rest.vo.UserVo;

public interface UserSerice {

	public UserModel createUser(UserModel userModel);
	
	public UserModel updateUser(UserModel userModel);
	
	public UserVo getByUserID(int userid);
	
	public List<UserVo> getAllUsers();
	
	public void deleteUser(int userid);
}
