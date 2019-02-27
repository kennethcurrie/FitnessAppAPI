package com.revature.services;

//this is the service layer
import java.util.List;

import com.revature.dto.Credentials;
import com.revature.model.AppUser;

public interface UserService {

	AppUser save(AppUser user);
	AppUser update(int id, String username, String password, String fullname, String email, boolean privateprofile);
	AppUser delete(AppUser user);
	AppUser login(Credentials creds);
	List<AppUser> search(String searchString);
	
	List<AppUser>findAll();
	AppUser findByUsername(String username);
	AppUser findById(int id);
	
}
