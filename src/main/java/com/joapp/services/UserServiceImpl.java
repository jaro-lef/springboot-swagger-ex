package com.joapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joapp.application.domain.User;
import com.joapp.dto.request.UserRequestDTO;
import com.joapp.dto.response.UserResponseDTO;
import com.joapp.repository.UserRepository;

@Service("JoapppUserServiceImpl")
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;	

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;		
	}

	@Override
	public UserResponseDTO saveUser(UserRequestDTO appaUserRequestDTO) {
		
		User user = new User();				
		user.setFirstName(appaUserRequestDTO.getFirstName());
		user.setLastName(appaUserRequestDTO.getLastName());		
		
		User save = userRepository.save(user);
		
		UserResponseDTO userResponseDTO = new UserResponseDTO(save.getId(), save.getFirstName(),
				save.getLastName());
		return userResponseDTO;
	}	

	@Override
	public UserResponseDTO getFirstUser() {

		List<User> findAll = userRepository.findAll();
		User user = null;
		if(findAll.size()>0) {
			user = findAll.get(0);
		}else {
			userNotFound();
		}		

		UserResponseDTO userResponseDTO = new UserResponseDTO(user.getId(), user.getFirstName(),
				user.getLastName());

		return userResponseDTO;
	}

	
	
	private Supplier<? extends RuntimeException> userNotFound() {
		return () -> new RuntimeException("User not found");
	}

	@Override
	public List<UserResponseDTO> getAllUser() {
				
		/*
		 * List<User> findAll = userRepository.findAll();
		 * List<UserResponseDTO> asDto = findAll.stream().map( s -> new
		 * UserResponseDTO(s.getId(), s.getFirstName() , s.getLastName())
		 * ).collect(Collectors.toList()); return asDto;
		 */
		return userRepository.findAll().stream().map(UserResponseDTO::new).collect(Collectors.toCollection(ArrayList::new));
		
	}	
}
