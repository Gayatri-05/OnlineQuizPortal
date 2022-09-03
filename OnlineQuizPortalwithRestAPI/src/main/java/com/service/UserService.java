package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Users;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository uRepo;
	
	public List<Users> getAllUsers() {
		return uRepo.findAll();
	}
}
