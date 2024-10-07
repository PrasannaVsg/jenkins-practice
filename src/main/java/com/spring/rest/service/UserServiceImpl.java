package com.spring.rest.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.rest.dao.UserRepo;
import com.spring.rest.entity.UserEntity;
import com.spring.rest.model.UserModel;
import com.spring.rest.vo.UserVo;

@Service
public class UserServiceImpl implements UserSerice {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public UserModel createUser(UserModel userModel) {
		UserEntity userentity=new UserEntity();
		BeanUtils.copyProperties(userModel, userentity);
		userentity=userRepo.save(userentity);
		BeanUtils.copyProperties(userentity, userModel);
		return userModel;
	}

	@Override
	public UserModel updateUser(UserModel userModel) {
		UserEntity userentity=userRepo.findById(userModel.getId()).orElseThrow(()->new RuntimeException("user not found"));
		userentity.setAge(userModel.getAge());
		userentity.setPassword(userModel.getPassword());
		userentity.setUserName(userModel.getUserName());
		userRepo.save(userentity);
		return userModel;
	}

	@Override
	public UserVo getByUserID(int userid) {
		UserEntity userentity=userRepo.findById(userid).orElseThrow(()->new RuntimeException("user not found"));
		UserVo userVo=new UserVo();
		BeanUtils.copyProperties(userentity, userVo);
		return userVo;
	}

	@Override
	public List<UserVo> getAllUsers() {
		List<UserEntity> userentity = userRepo.findAll();
		return userentity.stream().map((user) -> {
			UserVo uservo = new UserVo();
			BeanUtils.copyProperties(user, uservo);
			return uservo;
		}).collect(Collectors.toList());

	}

	@Override
	public void deleteUser(int userid) {
		userRepo.deleteById(userid);
	}

}
