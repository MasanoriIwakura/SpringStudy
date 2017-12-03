package com.example.springstudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springstudy.Entities.User;
import com.example.springstudy.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository repository;
	
	public User search(String id) {
		User user = repository.findOne(id);
		return user;
	}
}
