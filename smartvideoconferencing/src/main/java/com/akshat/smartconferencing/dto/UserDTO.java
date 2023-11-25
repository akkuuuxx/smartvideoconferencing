package com.akshat.smartconferencing.dto;

import javax.persistence.Id;

public class UserDTO {

	private String username;
	@Id
	private String email;
	private String password;
	private String status;
	
	public UserDTO(String username, String email, String password, String status) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
