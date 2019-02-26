package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.ExerciseLog;
import com.revature.services.ExerciseLogService;

@RestController
@RequestMapping("history")
public class HistoryController {
	@Autowired 
	ExerciseLogService history;
	
	@GetMapping
	public List<ExerciseLog> findAll() {
		return history.findAll();
	}
	
	@GetMapping("exercise/{exercise}")
	public List<ExerciseLog> findAllByExerciseDescription(@PathVariable String exercise) {
		return history.findAllByExerciseDescription(exercise);
	}
	
	@GetMapping("user/{id}")
	public List<ExerciseLog> findAllByUserId(@PathVariable int id) {
		return history.findAllByUserId(id);
	}
	
	@GetMapping("user/{id}/exercise/{exercise}")
	public List<ExerciseLog> findAllByUserIdAndExerciseDescription(@PathVariable int id, @PathVariable String exercise) {
		return history.findAllByUserIdAndExerciseDescription(id, exercise);
	}
}
