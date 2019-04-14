package masi_green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import masi_green.manager.RegisterUserManager;
import masi_green.model.request.RegisterUserRequest;

@RestController
public class RegisterUserController {

	@Autowired
	RegisterUserManager registerUserManager;
	
	@PostMapping(value = "/register_user")
	public String registerUser(@RequestBody RegisterUserRequest request) {
		return registerUserManager.registerUser(request).toString();
	}

}
