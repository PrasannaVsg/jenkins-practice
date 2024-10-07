package com.spring.rest.utill;

import org.springframework.beans.BeanUtils;

import com.spring.rest.model.UserModel;
import com.spring.rest.vo.UserVo;

public class UserMapper {
	
	public static UserVo toVo(UserModel model) {
		UserVo uservo=new UserVo();
		BeanUtils.copyProperties(model, uservo);
		return uservo;
	}
	
	public static UserModel toModel(UserVo uservo) {
		UserModel userModel=new UserModel();
		BeanUtils.copyProperties(uservo, userModel);
		return userModel;
	}
	
	

}
