package org.dnyanyog.controller;

import java.util.Optional;

import org.dnyanyog.dto.AddClientRequest;
import org.dnyanyog.dto.AddClientResponse;
import org.dnyanyog.service.ClientManagementImplememt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientManagementController {
	
	@Autowired 
	ClientManagementImplememt clientservice;
	@PostMapping(path="/api/auth/client", 
			consumes = {"application/json", "application/xml"},
		      produces = {"application/json", "application/xml"})
	public Optional<AddClientResponse> addUpdateClient(@RequestBody AddClientRequest request) {
		return clientservice.addclient(request);
	}
	
	@GetMapping(path="/api/auth/client/{userCode}")
	public AddClientResponse getSingleClient(@PathVariable Long userCode){
	    return clientservice.getSingleClient(userCode);
	}
	
	
	@PostMapping(path="/api/auth/clientupdate/{userCode}",
			consumes = {"application/json", "application/xml"},
		      produces = {"application/json", "application/xml"})
	public AddClientResponse updateClient (@RequestBody AddClientRequest request,@PathVariable long userCode) {
		return clientservice.upadteClient(userCode, request);
		
	}
	@DeleteMapping(path="/api/auth/deleteClient/{userCode}")
	public long deleteClient(@PathVariable long userCode) {
		return clientservice.deleteClient(userCode);
		
	}
		

	
	

}



