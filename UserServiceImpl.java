package com.learn.Ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.Ecommerce.Dto.UserDto;
import com.learn.Ecommerce.entity.User;
import com.learn.Ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
    @Autowired
	UserRepository userRepository;
    
	@Override
	public UserDto addUser(UserDto userDto) {
        UUID randomUUID = UUID.randomUUID();
        String id = randomUUID.toString();
        userDto.setId(id);
        User user = dtoToEntity(userDto);
        User savedUser = userRepository.save(user);
     UserDto savedDto = entityToDto(savedUser);
		return savedDto;
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = userRepository.findAll();
		List<UserDto> userDtoList = users.stream()
		.map(u->entityToDto(u))
		.collect(Collectors.toList());
		
		return userDtoList;
	}

	@Override
	public UserDto getUserById(String id) {

		User user = userRepository.findById(id)
		.orElseThrow(()->new RuntimeException(id+" not found"));
		
		return entityToDto(user);
	}

	@Override
	public UserDto updateUser(String id, UserDto userDto) {

		User user = userRepository.findById(id)
		.orElseThrow(()->new RuntimeException(id+" not found"));
		
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmailId(userDto.getEmailId());
		user.setAge(userDto.getAge());
		user.setPassword(userDto.getPassword());
		
		User updateUser = userRepository.save(user);
		return null;
	}

	@Override
	public String deleteUser(String id) {

		User user = userRepository.findById(id)
		.orElseThrow(()->new RuntimeException(id+ " not Found"));
		userRepository.delete(user);
		return user.getId()+"deleted successfully";
	}

	@Override
	public UserDto entityToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setPassword(user.getPassword());
		userDto.setEmailId(user.getEmailId());
		userDto.setAge(user.getAge());
		userDto.setAddress(user.getAddress());
		return userDto;
	}

	@Override
	public User dtoToEntity(UserDto userDto) {
		User user=new User();
		user.setId(userDto.getId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		user.setEmailId(userDto.getEmailId());
		user.setAge(userDto.getAge());
		user.setAddress(userDto.getAddress());
		return user;
	}
	
	//Optional<User> findByEmailId(String email);
	@Override
	public UserDto getUserByEmail(String email) {
		User user = userRepository.findByEmailId(email)
		.orElseThrow(()->new RuntimeException(email+" not found"));
		return entityToDto(user);
	}
	
	@Override
	public List<UserDto> getUserByFirstName(String firstName) {
		List<UserDto> userDtoList = userRepository.findByFirstName(firstName).stream()
		.map(u->entityToDto(u)).collect(Collectors.toList());
		
		return userDtoList;
	}

}
