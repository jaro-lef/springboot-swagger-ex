package com.joapp.dto.response;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.joapp.application.domain.User;

public class UserResponseDTO {

	private Long id;	
	
	private String firstName;

	private String lastName;	

	public UserResponseDTO(Long id, String firstName, String lastName) {
		this.id = id;		
		this.firstName = firstName;
		this.lastName = lastName;		
	}
	
	public UserResponseDTO(User u) {
		this.id = u.getId();		
		this.firstName = u.getFirstName();
		this.lastName = u.getLastName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	

	@Override
	public String toString() {

		return new ToStringBuilder(this).append("firstName", firstName).append("lastName", lastName)
			.toString();
	}

}
