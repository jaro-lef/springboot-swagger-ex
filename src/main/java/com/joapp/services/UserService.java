package com.joapp.services;

import java.util.List;

import com.joapp.dto.request.UserRequestDTO;
import com.joapp.dto.response.UserResponseDTO;

public interface UserService {

	UserResponseDTO saveUser(UserRequestDTO appaUserRequestDTO);
	
	List<UserResponseDTO> getAllUser();

	UserResponseDTO getFirstUser();

}