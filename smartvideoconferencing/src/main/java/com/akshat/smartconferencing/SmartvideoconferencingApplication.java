package com.akshat.smartconferencing;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.akshat.smartconferencing.entity.User;
import com.akshat.smartconferencing.exception.SmartConferencingException;
import com.akshat.smartconferencing.repository.UserRepository;
import com.akshat.smartconferencing.service.UserService;

@SpringBootApplication
public class SmartvideoconferencingApplication {


	public static void main(String[] args) throws SmartConferencingException {
		ApplicationContext context= SpringApplication.run(SmartvideoconferencingApplication.class, args);
		UserRepository repository=context.getBean(UserRepository.class);
		UserService service=context.getBean(UserService.class);;
//		User user = new User();
//		user.setUsername("Akku");
//		user.setEmail("abc@gmail.com");
//		user.setPassword("Abc@123");
//		user.setStatus("Online");
//		repository.save(user);
//		Optional<User> user=repository.findById("abc@gmail.com");
//		System.out.println(user.get().getUsername());
		
//		User user=repository.findByEmailAndPassword("abc@gmail.com","Abc@123");
//		System.out.println(user.getUsername());
//		
		
//		Optional<User> userOptional=repository.findById("abc@gmail.com");
//		 User user = userOptional.orElseThrow(()->new RuntimeException("User does not exist !!!"));
//		 System.out.println(user.getUsername());
//		 System.out.println(user.getPassword());
//		 if(user.getPassword().toString()=="Abc@123") {
//			 System.out.println(user.getPassword());
//		 }
//		 else { 
//			 throw new RuntimeException("Password Incorrect");
////		 }
//		User user= service.userLogin("abc@gmail.com","Abc@123");
//		System.out.println(user.getUsername());
		
//	 User user=	service.passwordReset("akshat@gmail.co",Date.valueOf("2002-07-01"));
//	 System.out.println(user.getEmail()+user.getPassword());
	}
	

}
