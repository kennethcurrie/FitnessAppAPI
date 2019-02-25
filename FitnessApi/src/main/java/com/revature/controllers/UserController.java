package com.revature.controllers;

//this is the router 
// ** these are the available endpoints

//*URL/users [ method: GET ] - gets all users

//*URL/users/:id [ method: GET ] - gets specific user

//*URL/users/username/:username [ method: GET ] - gets specific user

//*URL/users/:id [ method: DELETE ] - deletes (or archives) a user

//URL/users/current [ method: GET ] - gets the currently logged in user. May be useful only in testing, 
//		but useful if you suspect the page state has reset because user pressed refresh. 
//		may not work with java web tokens?

//URL/users/ [ method: POST ] - create or update user
//POST was chosen over PUT because newly supplied users WILL NOT have whatever id the user
//supplies, therefore creating and updating would function differently and 
//specifically creating new resource would not work as expected
//get user from database, if it exists update it with fields that arn't null on the incoming object
//updateUser(newUser)
//{
//	user oldUser = new user();
//	if(User dbUser = getUserFromDb(newUser.userId)) oldUser = dbUser;
//	oldUser.updateWith(newUser);
//	if(oldUser.isValid()) sendToDB(oldUser);
// 	else abort transaction
//}

//URL/users/:id/pics?date={int}&quantity={int}&searchmode={forwards : backwards} [ method: GET ] get users progress pics array
//give it a date, a quantity to retrieve, and an enum to say search forwards or backwards.
//it will return an array with up to that quantity pics


import java.util.ArrayList;
import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
//	private static Logger log = LogManager.getRootLogger();

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
		
		System.out.println(user);
		AppUser u = userService.save(user);
		System.out.println(u);
		return u;
	}

	@RequestMapping (value="/{id}/pics", method=RequestMethod.GET, 
            produces="application/json")
	public ResponseEntity<List<String>> getUserPicURLs(@PathVariable int id,
		@RequestParam(value = "date", required = false, defaultValue="9223372036854775806") long date,//default: the max long
		@RequestParam(value = "quantity", required = false, defaultValue="10") String quantity,
		@RequestParam(value = "searchmode", required = false, defaultValue="backwards") String searchMode
	) {
		ArrayList<String> result = new ArrayList<String>();
		result.add("success!" + " date=" + date + " quantity=" + quantity + " searchmode=" + searchMode);
		return new ResponseEntity<List<String>>(result, HttpStatus.OK);
	}
	
	

}
