package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.AppUser;
import com.revature.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	List<AppUser> users = new ArrayList<>();
	{
	}
	
	@Autowired
	UserService userService;

	@GetMapping
	public List<AppUser> findAll() {
		
//		return new ArrayList<AppUser>();
		return userService.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<AppUser> findById(@PathVariable int id) {
		for (AppUser user : findAll()) {
			if (user.getId() == id) {
				return new ResponseEntity<AppUser>(user, HttpStatus.ACCEPTED);
			}
		}
		return new ResponseEntity<AppUser>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("username/{username}")
	public ResponseEntity<AppUser> findByUserName(@PathVariable String username) {
		for (AppUser user : findAll()) {
			if (user.getUserName().equals(username) ) {
				return new ResponseEntity<AppUser>(user, HttpStatus.ACCEPTED);
			}
		}
		return new ResponseEntity<AppUser>(HttpStatus.NOT_FOUND);
	}

	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public AppUser save(@RequestBody AppUser user) {
		user.setId(users.size() + 1);
		users.add(user);
		return user;
	}

}
