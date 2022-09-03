package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Login;
import com.repository.LoginRepository;
import com.service.QuizService;

@RestController
@RequestMapping(value="participants")
public class UserController {
	
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	QuizService qzService;
	
	@PostMapping("register")
	public String registerUser(@RequestBody Login newUser) {
		List<Login> users=loginRepository.findAll();
		System.out.println("New user: " + newUser.toString());

        for (Login user : users) {
            System.out.println("Registered user: " + newUser.toString());

            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return "User already exists";
            }
	}
        loginRepository.save(newUser);
        return "Registered successfully";
	}
	
	@PostMapping("login")
	public String loginUser(@RequestBody Login user) {
		List<Login> users = loginRepository.findAll();

        for (Login other : users) {
            if (other.equals(user)) {
                loginRepository.save(user);
                return "Login Succesfull";
            }
        }

        return "Login failure";
	}
	
	@PostMapping("logout")
	public String logoutUser(@RequestBody Login user) {
		List<Login> users = loginRepository.findAll();

        for (Login other : users) {
            if (other.equals(user)) {
                loginRepository.save(user);
                return "Logout Succesfull";
            }
        }

        return "Logout failure";
	}
	
}
