package com.jwt.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.example.model.User;

@Service
public class UserService {

	private List<User> store = new ArrayList<User>();

	public UserService() {
		store.add(new User(UUID.randomUUID().toString(), "Harshal", "abc@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(), "Java", "pqr@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(), "php", "mno@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(), "DotNet", "xyz@gmail.com"));
	}

	public List<User> getUsers(){
		return store;
	}
}
