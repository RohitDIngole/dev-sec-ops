package dnyanyog.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dnyanyog.dto.LoginRequest;
import dnyanyog.dto.LoginResponse;
import dnyanyog.entity.Users;
import dnyanyog.repo.UsersRepository;

@Service
public class LoginService {

	@Autowired
	UsersRepository userRepo;

	public LoginResponse validate(LoginRequest loginRequest) {
		LoginResponse response = new LoginResponse();
          List<Users> liUsers=userRepo.findByUsernameAndPassword(loginRequest.getUsername(),loginRequest.getPassword());
          
          if(liUsers.size()==1) {
        	  response.setStatus("Successful");
        	  response.setMessage("Login Successfull");
          }
          else {
        	  response.setStatus("Uncessfull");
        	  response.setMessage("Login Fail");
          }

		return response;
	}
}
