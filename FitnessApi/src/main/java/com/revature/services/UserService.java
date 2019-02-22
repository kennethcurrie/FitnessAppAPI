package com.revature.services;


import java.util.List;

import com.revature.model.AppUser;

public interface UserService {

	AppUser save(AppUser user); // add a bear
	AppUser update(AppUser user);
	AppUser delete(AppUser user);
	
	List<AppUser>findAll();
	
}
