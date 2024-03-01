package dnyanyog.services;



import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import dnyanyog.dto.User;
import dnyanyog.dto.UserRequest;
import dnyanyog.dto.UserResponse;
import dnyanyog.entity.Users;
import dnyanyog.repo.UsersRepository;

@Service
public class UserService {

	@Autowired
	UsersRepository userRepo;

	@Autowired
	UserResponse userresponse;
	public UserResponse adduser(@RequestBody UserRequest userRequest) {
		

		Users usersTable = new Users();

		usersTable.setAge(userRequest.getAge());
		usersTable.setEmail(userRequest.getEmail());
		usersTable.setPassword(userRequest.getPassword());
		usersTable.setUsername(userRequest.getUsername());

		userRepo.save(usersTable);

		userresponse.setStatus("Success");
		userresponse.setMessage("User successfully added");
		userresponse.getUserdata().setUsername(usersTable.getUsername());
		userresponse.getUserdata().setAge(usersTable.getAge());
		userresponse.getUserdata().setPassword(usersTable.getPassword());
		userresponse.getUserdata().setEmail(usersTable.getEmail());

		return userresponse;

	}
	public UserResponse getSingleUser(Long userId) {
		
		Optional<Users> recieveData=userRepo.findById(userId);
		if(recieveData.isEmpty()) {
			userresponse.setStatus("fail");
			userresponse.setMessage("user not found");
			
		}
		else {
			Users user=recieveData.get();
			userresponse.setStatus("Success");
			userresponse.setMessage("found");
			userresponse.setUserId(userId);
			userresponse.getUserdata().getAge();
			userresponse.getUserdata().getEmail();
			userresponse.getUserdata().getPassword();
			userresponse.getUserdata().getUsername();
			

			
		}
		return userresponse;
		
		
		
	}
	public List<Users> getAllUser(){
		return userRepo.findAll();
		
	}
	


	public List<Long>getAllId(){
		
		 List<Long> userIds=new ArrayList();
		List<Long> users=userRepo.findByAllUserId();
		
		
	return userIds;
	}
}
