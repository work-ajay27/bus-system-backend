package com.prada.repository;

import com.prada.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//User → Which table you want to interact with
//This repository will work on the User table.”
//Long → What is the datatype of your primary key

public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByEmail(String email);

	User findByEmail(String email);
}

//Used to check duplicate emails
// Used for login validation