package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.TaskRepository;
import com.project.entity.Task;

@Service
public class TaskServiceImp implements TaskService{
	
	private TaskRepository taskRepo;
	
	@Autowired
	public TaskServiceImp(TaskRepository taskRepo) {
		super();
		this.taskRepo = taskRepo;
	}

	@Override
	public Task saveTask(Task task) {
		return taskRepo.save(task);
	}

	@Override
	public List<Task> getAllTask() {
		List<Task> allTask = taskRepo.findAll();
		return allTask;
	}

	@Override
	public void deleteTask(int id) {
		taskRepo.deleteById(id);
	}

	@Override
	public Task findByID(int id) {
		Optional<Task> findByid=taskRepo.findById(id);
		Task ts=findByid.get();
		return ts;
	}

	@Override
	public Task updateTask(Task task) {
		return taskRepo.save(task);
	}

}
