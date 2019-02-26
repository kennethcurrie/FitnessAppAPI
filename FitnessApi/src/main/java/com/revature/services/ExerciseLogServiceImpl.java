package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.ExerciseLog;
import com.revature.repos.ExerciseLogRepo;


@Service
public class ExerciseLogServiceImpl implements ExerciseLogService {

	
	@Autowired
	private ExerciseLogRepo history;
	
	@Override
	public ExerciseLog save(ExerciseLog history) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExerciseLog update(ExerciseLog history) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExerciseLog delete(ExerciseLog history) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExerciseLog> findAll() {
	  return history.findAll();
	}

	@Override
	public List<ExerciseLog> findAllByExerciseDescription(String name) {
		// TODO Auto-generated method stub
		return history.findAllByExerciseDescription(name);
	}

	@Override
	public List<ExerciseLog> findAllByUserId(int id) {
		// TODO Auto-generated method stub
		return history.findAllByUserId(id);
	}

	@Override
	public List<ExerciseLog> findAllByUserIdAndExerciseDescription(int id, String name) {
		// TODO Auto-generated method stub
		return history.findAllByUserIdAndExerciseDescription(id, name);
	}

}
