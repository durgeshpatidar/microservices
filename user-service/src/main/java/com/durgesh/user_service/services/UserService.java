package com.durgesh.user_service.services;

import java.util.List;

import com.durgesh.user_service.entities.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUser();
	User getUser(String userId);
	//delete, update
}
