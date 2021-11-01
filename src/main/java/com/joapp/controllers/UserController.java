package com.joapp.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joapp.HelloWorld;
import com.joapp.dto.request.UserRequestDTO;
import com.joapp.dto.response.UserResponseDTO;
import com.joapp.services.UserService;


@RestController
@Validated
@RequestMapping("/api")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value(value = "${spring.profiles.active}")
	String prop;
	
	@Autowired
	private HelloWorld hw;	

	@Autowired
	private UserService appaUserService;	
	
	/*public UserController(HelloWorld hw) {		
		this.hw = hw;		
	}*/

	@PostConstruct
	public void postConstruct() {
		logger.info("PostConstruct: "+prop);
		hw.setMessage("hhhhwooorld");
		logger.info(hw.getMessage());
	}

	@PostMapping("/new")
	public ResponseEntity<UserResponseDTO> saveUser(
			@Valid @RequestBody UserRequestDTO appaUserRequestDTO) {

		UserResponseDTO saveUser = appaUserService.saveUser(appaUserRequestDTO);
		return new ResponseEntity<UserResponseDTO>(saveUser, HttpStatus.OK);
	}
	

	@GetMapping("/current")
	public ResponseEntity<UserResponseDTO> getCurrentUser() {

		UserResponseDTO appaUserResponseDTO = appaUserService.getFirstUser();
		return new ResponseEntity<UserResponseDTO>(appaUserResponseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserResponseDTO>> getAllUser() {

		List<UserResponseDTO> allUser = appaUserService.getAllUser();
		return new ResponseEntity<List<UserResponseDTO>>(allUser, HttpStatus.OK);
	}
	
}
