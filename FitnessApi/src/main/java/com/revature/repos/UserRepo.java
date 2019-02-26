package com.revature.repos;



//this is the data access object

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.model.AppUser;

public interface UserRepo extends JpaRepository<AppUser, Integer> {
}
