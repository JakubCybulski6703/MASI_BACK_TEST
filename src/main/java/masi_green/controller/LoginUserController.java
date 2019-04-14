package masi_green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import masi_green.manager.LoginUserManager;
import masi_green.model.request.LoginUserRequest;

@RestController
public class LoginUserController {

	@Autowired
	LoginUserManager loginUserManager;
	
	@PostMapping(value = "/login")
	public String registerUser(@RequestBody LoginUserRequest request) {
		return loginUserManager.login(request).toString();
	}

}
