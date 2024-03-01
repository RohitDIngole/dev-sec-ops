package org.dnyanyog.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddClientResponse {
	private String status;
	private String message;
	private String userId;
	@Autowired
	ClientData clientData;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ClientData getClientData() {
		return clientData;
	}
	public void setClientData(ClientData clientData) {
		this.clientData = clientData;
	}
	

}
