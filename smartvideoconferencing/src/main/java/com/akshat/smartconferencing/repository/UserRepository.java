package com.akshat.smartconferencing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akshat.smartconferencing.entity.User;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, String> {

	public User findByEmailAndPassword(String email, String password);
	public Optional<User> findByEmailAndDateofbirth(String email,Date dateofbirth);
}
