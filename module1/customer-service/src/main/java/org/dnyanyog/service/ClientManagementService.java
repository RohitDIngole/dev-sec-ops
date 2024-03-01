package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.AddClientRequest;
import org.dnyanyog.dto.AddClientResponse;

public interface ClientManagementService {
	Optional<AddClientResponse> addclient(AddClientRequest request);
	AddClientResponse getSingleClient(Long usercode);
	
	AddClientResponse upadteClient(Long usercode,AddClientRequest request);
	
	long deleteClient(long usercode);

}
