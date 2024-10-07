package com.spring.rest.controler;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.rest.model.UserModel;
import com.spring.rest.service.UserSerice;
import com.spring.rest.vo.UserVo;

@RestController
@RequestMapping("/user")
public class UserControler {
	
	@Autowired
	UserSerice userSerice;

	@PostMapping("/create-user")
	public EntityModel<ResponseEntity<UserModel>>  createUser(@RequestBody UserModel userModel) {
		UserModel usermdl = userSerice.createUser(userModel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usermdl.getId()).toUri();
		EntityModel<ResponseEntity<UserModel>> entity=EntityModel.of(ResponseEntity.created(uri).body(usermdl));
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getAllUsers());
		entity.add(link.withRel("all-users"));
		return entity;
	}
	
	@GetMapping("/get-all-users")
	public ResponseEntity<List<UserVo>> getAllUsers() {
		List<UserVo> usermdl = userSerice.getAllUsers();
		return ResponseEntity.ok().body(usermdl);
	}
	
	@PutMapping("/update-user")
	public ResponseEntity<UserModel> updateUser(@RequestBody UserModel userModel) {
		userModel=userSerice.updateUser(userModel);
		return new ResponseEntity<UserModel>(userModel,HttpStatus.OK);
	}
	
	@GetMapping("/get-user/{id}")
	public ResponseEntity<UserVo> updateUserByid(@PathVariable Integer id) {
		UserVo userVo= userSerice.getByUserID(id);
		return new ResponseEntity<UserVo>(userVo,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userSerice.deleteUser(id);
	}
}
