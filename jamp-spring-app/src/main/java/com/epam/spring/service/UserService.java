package com.epam.spring.service;

import com.epam.spring.model.User;

public interface UserService extends CommonService<User>{
	
	User getUserByEmail(String email);
}
