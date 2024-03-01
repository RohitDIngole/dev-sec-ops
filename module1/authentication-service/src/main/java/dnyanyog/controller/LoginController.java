package dnyanyog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dnyanyog.dto.LoginRequest;
import dnyanyog.dto.LoginResponse;
import dnyanyog.services.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping(path = "/public/auth/validate", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public LoginResponse validate(@RequestBody LoginRequest loginRequest) {

		return loginService.validate(loginRequest);
	}

}
