package com.akshat.smartconferencing.entity;






import java.sql.Date;

import org.hibernate.annotations.GeneratedColumn;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class User {

	private String name;
	private String username;
	@Id 
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String email;
	private String password;
	private String status;
	private Date dateofbirth;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(String name, String username, String email, String password, String status, Date dateofbirth) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.status = status;
		this.dateofbirth = dateofbirth;
	}
	public Date getdateofbirth() {
		return dateofbirth;
	}
	public void setdateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
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
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
