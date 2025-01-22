package com.learn.Ecommerce.service;

import java.util.List;

import com.learn.Ecommerce.Dto.UserDto;
import com.learn.Ecommerce.entity.User;

public interface UserService{
	
	//To add User
	UserDto addUser(UserDto userDto);
	
	//To Fetch All User
	List<UserDto> getAllUsers();
	
	//To Fetch User by Id
	UserDto getUserById(String id);
	
	//Update user by Id
	UserDto updateUser(String id,UserDto userDto);
	
	//To delete user by Id
	String deleteUser(String id);
	
	//Entity to DTO conversion
	UserDto entityToDto(User user);
	
	//Dto to entity conversion
	User dtoToEntity(UserDto userDto);
	
    //To Fetch User By EmailId
	UserDto getUserByEmail(String email);
	
	//To Fetch User By FirstName
	List<UserDto> getUserByFirstName(String firstName);
}
