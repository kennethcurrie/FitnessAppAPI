package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.AppUser;
import com.revature.repos.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public AppUser save(AppUser user) {
		return userRepo.save(user);
	}

	@Override
	public AppUser update(AppUser user) {
		return userRepo.save(user);
	}

	@Override
	public AppUser delete(AppUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppUser> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
		
	}
	
	

}
