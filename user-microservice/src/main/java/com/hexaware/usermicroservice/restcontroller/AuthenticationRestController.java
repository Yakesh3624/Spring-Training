package com.hexaware.usermicroservice.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.usermicroservice.dto.CredentialDTO;
import com.hexaware.usermicroservice.dto.UsersDTO;
import com.hexaware.usermicroservice.entity.Credential;
import com.hexaware.usermicroservice.entity.Users;
import com.hexaware.usermicroservice.exception.DataAlreadyExistException;
import com.hexaware.usermicroservice.service.IUsersService;
import com.hexaware.usermicroservice.service.JwtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationRestController {
	@Autowired
	IUsersService service;

	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/login/login")
	public String authenticateAndGetToken(@RequestBody Credential credential) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(credential.getUserName(), credential.getPassword()));

		String token = null;

		if (authentication.isAuthenticated()) {
			token = jwtService.generateToken(credential.getUserName());

		} else {
			throw new UsernameNotFoundException("UserName or Password in Invalid / Invalid Request");
		}

		return token;
	}

	@PostMapping("/login/register")
	public UsersDTO addUsers(@RequestBody @Valid Users users) throws DataAlreadyExistException {
		return service.addUsers(users);
	}

	@PostMapping("/set/username-password")
	public CredentialDTO addCredential(@RequestBody Credential credential) throws Exception {
		return service.addCredential(credential);
	}

}
