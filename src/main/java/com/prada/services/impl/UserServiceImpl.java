package com.prada.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prada.dto.SignupRequest;
import com.prada.model.User;
import com.prada.repository.UserRepository;
import com.prada.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String signup(SignupRequest request) {

        // 1. Check if user already registered
        if (userRepository.existsByEmail(request.getEmail())) {
            return "User already registered";
        }

        // 2. Create new User entity
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());  // (Later we will hash password)

        // 3. Save user in DB
        userRepository.save(user);

        return "Signup successful";
    }
}
