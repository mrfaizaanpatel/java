package com.learn.Ecommerce.Dto;

import com.learn.Ecommerce.Validitor.PasswordMatch;
import com.learn.Ecommerce.entity.Address;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatch
public class UserDto {

	private String id;
	@NotNull
	@NotBlank(message="FirstName cannot be Blank")
	@Size(min = 2,max = 20)
	private String firstName;
	@NotNull
	@NotBlank(message="lastName cannot be Blank")
	@Size(min = 2, max = 20)
	private String lastName;
	@NotNull
	@NotBlank(message = "Emailid Cannot be Blank")
	@Pattern(regexp="^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$")
	private String emailId;
	@NotNull
	@NotBlank(message = "password cannot be Blank")
	@Pattern(regexp="^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$")
	private String password;
	@NotNull
	@NotBlank
	private String confirmPassword;
	@NotNull
	@Min(13)
	@Max(150)
	private int age;
	private Address address;
	
}
