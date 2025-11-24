package com.TrueFare.controller;

import com.TrueFare.security.JwtUtil;
import com.google.gson.Gson;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

	@PostMapping("/mojo-verify")
	public ResponseEntity<?> verify(@RequestBody Map<String, Object> request) throws Exception {

	    // Phone OTP returns identifier like +91XXXXXXXXXX
	    String phone = request.get("identifier").toString();

	    // You can save user here or lookup existing user

	    String jwt = JwtUtil.generateToken(phone);

	    return ResponseEntity.ok(Map.of(
	            "message", "Login Successful",
	            "phone", phone,
	            "jwt", jwt
	    ));
	}


	
}
