package com.joapp.application.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;


@Entity
@Table(name = "users")
public class User extends AbstractEntity<Long> {

	private String firstName;

	private String lastName;

	

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
