package org.dnyanyog.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Client {
	
	@GeneratedValue//Auto generated(DB=> sequence),primary key
	@Id
	@Column(name="userCode",nullable=false,updatable=false,insertable=false)
	private long userCode;
	
	@Column(name="clientId",nullable=false,updatable=false)
	private long clientId;
	
	@Column(name="clientname",nullable=false,updatable=false)
	private String clientname;
	
	@Column
	private  String password;
	
	@Column
	private String email;
	
	@Column
	private String contactnumber;
	
	@Column
	private String age;
	
	@Column
	private String gender;

	public long getUserCode() {
		return userCode;
	}

	public void setUserCode(long userCode) {
		this.userCode = userCode;
	}

	public long getUserId() {
		return clientId;
	}

	public void setUserId(long userId) {
		this.clientId = userId;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
	

}
