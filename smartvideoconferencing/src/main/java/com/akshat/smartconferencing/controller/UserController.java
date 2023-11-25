package com.akshat.smartconferencing.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshat.smartconferencing.entity.User;
import com.akshat.smartconferencing.exception.SmartConferencingException;
import com.akshat.smartconferencing.service.UserService;

@RestController
@RequestMapping("app/")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<String>  userRegister(@RequestBody User user) throws SmartConferencingException {
		return  new ResponseEntity<String>( service.userRegister(user),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> userLogin(@RequestBody User user)throws SmartConferencingException {
		return new ResponseEntity<User>(service.userLogin(user),HttpStatus.OK);
	}
	
	@GetMapping("/logout/{email}/{password}")
	public ResponseEntity<String> userLogout(@RequestBody @PathVariable("email") String email,@PathVariable("password") String password) throws SmartConferencingException {
		return new ResponseEntity<String>(service.userLogout(email, password), HttpStatus.OK);
	}
	

	@GetMapping("/allusers")
	public ResponseEntity<List<User>> allUsers() {
	
		return new ResponseEntity<List<User>>(service.allUsers(),HttpStatus.OK);
		
	}
	
	@PostMapping("/resetpassword")
	public ResponseEntity<User> passwordReset(@RequestBody User user) throws SmartConferencingException{
		
		
        return new ResponseEntity<User>(service.passwordReset(user),HttpStatus.OK) ;
	}
	
	@PutMapping("/updatepassword")
public ResponseEntity<String> updatePassword(@RequestBody User user) throws SmartConferencingException{
		
		 return new ResponseEntity<String>(service.updatePassword(user),HttpStatus.OK) ;
	
	}
	
}
