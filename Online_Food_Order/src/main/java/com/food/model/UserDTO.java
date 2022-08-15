package com.food.model;

import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	@Pattern(regexp="[a-z]{6,12}", message = "Username must be between 6 to 12 characters. Must only contain lowercase characters.")
	private String userName;
	

	@Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
	private String userPassword;

	@Pattern(regexp="[a-zA-Z]{3,12}", message = "First Name must not contains numbers or special characters")
	private String firstName;

	@Pattern(regexp="[a-zA-Z]{3,12}", message = "Last Name must not contains numbers or special characters")
	private String lastName;

}
