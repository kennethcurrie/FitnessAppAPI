package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.ExerciseLog;

public interface ExerciseLogRepo extends JpaRepository<ExerciseLog, Integer> {
	
	List<ExerciseLog> findAllByExerciseDescription(String exerciseExerciseId);
}
