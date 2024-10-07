package com.spring.rest.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

	private Integer id;
	
	@Size(min = 2,max = 10,message = "Name length should be greater then 2 and less then 10")
	private String userName;

	private String password;

	private Integer age;

}
