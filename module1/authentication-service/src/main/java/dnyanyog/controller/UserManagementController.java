package dnyanyog.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dnyanyog.dto.User;
import dnyanyog.dto.UserRequest;
import dnyanyog.dto.UserResponse;
import dnyanyog.entity.Users;
import dnyanyog.services.UserService;

@RestController
public class UserManagementController {

	@Autowired
	UserService addUserService;

	@PostMapping(path = "/api/auth/add-user", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public UserResponse adduser(@RequestBody UserRequest addUserRequest) {
		return addUserService.adduser(addUserRequest);

	}
	@GetMapping(path="/api/auth/add-user/{userId}")
	public UserResponse getSingleUser(@PathVariable Long userId) {
		return addUserService.getSingleUser(userId);
	}
	@GetMapping(path="/api/auth/add-user/all-ids")
	public List<Users> getAllUser(){
		return addUserService.getAllUser();}
	  @GetMapping(path="/ api/auth/add-user")
          public List<Long> getAllId(){
	return addUserService.getAllId();
	}
	  
}
