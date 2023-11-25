package com.akshat.smartconferencing.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshat.smartconferencing.dto.UserDTO;
import com.akshat.smartconferencing.entity.User;
import com.akshat.smartconferencing.exception.SmartConferencingException;
import com.akshat.smartconferencing.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public String userRegister(User user) throws SmartConferencingException {
//		UserDTO userDTO=new UserDTO(user.getUsername(),user.getEmail(),user.getPassword(),user.getStatus());
//		User user1=new User(userDTO.getUsername(),userDTO.getEmail(),userDTO.getPassword(),userDTO.getStatus());
		Optional<User> userOptional=repository.findById(user.getEmail());
		if(userOptional.isPresent()) {
			throw new SmartConferencingException("A user with this email address is already present !!!");
		}
		user.setStatus("Offline");
		return repository.save(user).getUsername()+" is registered successfully";
	}
	public User userLogin(User user) throws SmartConferencingException {
		Optional<User> userOptional=repository.findById(user.getEmail());
		 User user1 = userOptional.orElseThrow(()->new SmartConferencingException("Oh No ! User does not exist !!!"));
		 if(user1.getPassword().equals(user.getPassword())) {
			 user1.setStatus("Online");
			 repository.save(user1);
			 return user1;}
		 else {
			 throw new SmartConferencingException("Oops ! Password is Incorrect");
		 }
	}
	
	public String userLogout(String email, String password) throws SmartConferencingException {
		Optional<User> userOptional=repository.findById(email);
		//System.out.println(userOptional.get().getUsername());
		 User user = userOptional.orElseThrow(()->new SmartConferencingException("User does not exist !!!"));
		 if(user.getPassword().equals(password)) {
			user.setStatus("Offline");
		    repository.save(user);
     	 return "User "+user.getName() + " is logout successfully !!!";
		 }
		 else {
			 throw new SmartConferencingException("Password Incorrect");
		 }
	}
	
	public List<User> allUsers(){
	
		return 	(List<User>) repository.findAll();

	}
	
	public User passwordReset(User user) throws SmartConferencingException{
		
	
		Optional<User> userOptional=repository.findByEmailAndDateofbirth(user.getEmail(),user.getdateofbirth());
		User user1 = userOptional.orElseThrow(()->new SmartConferencingException("Incorrect Email & Date Of Birth , Please recheck !!!"));
        return user1 ;
	}
	
	public String updatePassword(User user) throws SmartConferencingException{
		
		
		Optional<User> userOptional=repository.findById(user.getEmail());
		User user1 = userOptional.orElseThrow(()->new SmartConferencingException("No user found with this email !!!"));
		user1.setPassword(user.getPassword());
		repository.save(user1);
        return "Password of "+user1.getEmail()+" is updated successfully !! " ;
	}
}
