package com.learn.Ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.Ecommerce.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	Optional<User> findByEmailId(String email);
	List<User> findByFirstName(String Firstname);
	List<User> findByLastName(String Lastname);
	List<User> findByFirstNameStartingWith(String Firstname);

}
