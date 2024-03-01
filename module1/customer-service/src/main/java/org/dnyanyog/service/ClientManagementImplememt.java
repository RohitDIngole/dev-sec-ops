package org.dnyanyog.service;


import java.util.Optional;


import org.dnyanyog.dto.AddClientRequest;
import org.dnyanyog.dto.AddClientResponse;
import org.dnyanyog.entity.Client;
import org.dnyanyog.repo.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ClientManagementImplememt implements ClientManagementService{
	
	Logger logger=LoggerFactory.getLogger(ClientManagementService.class);
	@Autowired 
	ClientRepository clientRepo;
	
	@Autowired
	AddClientResponse clientResponse;

	@Override
	public Optional<AddClientResponse> addclient(AddClientRequest request) {
		// TODO Auto-generated method stub
		
		Client clientTable=new Client();
		clientTable.setClientname(request.getClientname());
		clientTable.setPassword(request.getPassword());
		clientTable.setEmail(request.getEmail());
		clientTable.setContactnumber(request.getContactnumber());
		clientTable.setAge(request.getAge());
		clientTable.setGender(request.getGender());
		
		
		clientTable =clientRepo.save(clientTable);
		
		clientResponse.setMessage("Client Added Successfully");
		clientResponse.setStatus("Successfull");
		clientTable.getUserId();
		clientResponse.getClientData().setClientname(clientTable.getClientname());
		clientResponse.getClientData().setPassword(clientTable.getPassword());
		clientResponse.getClientData().setEmail(clientTable.getEmail());
		clientResponse.getClientData().setContactnumber(clientTable.getContactnumber());
		clientResponse.getClientData().setAge(clientTable.getAge());
		clientResponse.getClientData().setGender(clientTable.getGender());
		return Optional.of(clientResponse);
	}

	@Override
	public AddClientResponse getSingleClient(Long usercode) {
		// TODO Auto-generated method stub
		Optional<Client> recievedData=clientRepo.findById(usercode);
		if(recievedData.isEmpty()) {
			clientResponse.setStatus("Fail");
			clientResponse.setMessage("Client Not Found");
			
		}
		else {
			Client client=recievedData.get();
			clientResponse.setStatus("Success");
			clientResponse.setMessage("User Found");
			clientResponse.getClientData().setClientname(client.getClientname());
			clientResponse.getClientData().setPassword(client.getPassword());
			clientResponse.getClientData().setEmail(client.getEmail());
			clientResponse.getClientData().setContactnumber(client.getContactnumber());
			clientResponse.getClientData().setAge(client.getAge());
			clientResponse.getClientData().setGender(client.getGender());
		}
		
		return clientResponse;
	}


	@Override
	public AddClientResponse upadteClient(Long usercode, AddClientRequest request) {
		// TODO Auto-generated method stub
		
		Optional<Client> receivedData = clientRepo.findById(usercode);
	    if (receivedData.isPresent()) {
	        Client clientTable = receivedData.get();

	        // Update the existing Client instance
	        clientTable.setClientname(request.getClientname());
	        clientTable.setPassword(request.getPassword());
	        clientTable.setEmail(request.getEmail());
	        clientTable.setContactnumber(request.getContactnumber());
	        clientTable.setAge(request.getAge());
	        clientTable.setGender(request.getGender());

	        // Save the updated Client instance
	        clientTable = clientRepo.save(clientTable);

			clientResponse.setMessage("Client Added Successfully");
			clientResponse.setStatus("Successfull");
			clientTable.getUserId();
			clientResponse.getClientData().setClientname(clientTable.getClientname());
			clientResponse.getClientData().setPassword(clientTable.getPassword());
			clientResponse.getClientData().setEmail(clientTable.getEmail());
			clientResponse.getClientData().setContactnumber(clientTable.getContactnumber());
			clientResponse.getClientData().setAge(clientTable.getAge());
			clientResponse.getClientData().setGender(clientTable.getGender());
			
			
			
			
		}
		else {
			clientResponse.setStatus("Fail");
			clientResponse.setMessage("User Not found");
		}
		
		return clientResponse;
	}

	@Override
	public long deleteClient(long usercode) {
		
		clientRepo.deleteById(usercode);
		
		// TODO Auto-generated method stub
		return usercode;
	}
	
	

	

}
