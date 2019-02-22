package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.AppUser;

public interface UserRepo extends JpaRepository<AppUser, Integer> {
}
