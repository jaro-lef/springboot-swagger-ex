package com.joapp.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;



public class UserRequestDTO {
	
	@NotNull
	@Size(min = 1, max = 20)
	private String firstName;

	@NotNull
	@Size(min = 1, max = 50)
	private String lastName;
	

	public UserRequestDTO() {
	}

	public UserRequestDTO(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/*@Override
	public String toString() {
		//TODO sprawdzic dzialanie toString
		return "UserRequestDTO [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", profileName=" + profileName + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword
				+ ", newRepeatedPassword=" + newRepeatedPassword + ", roleName=" + roleName + "]";
	}	*/
	
	@Override
	public String toString() {
		//TODO sprawdzic dzialanie toString
		return new ToStringBuilder(this).append("firstName", firstName).append("lastName", lastName)
				.toString();
	}
	
	
}
