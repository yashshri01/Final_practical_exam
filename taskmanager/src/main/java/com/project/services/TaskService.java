package com.project.services;

import java.util.List;

import com.project.entity.Task;

public interface TaskService {
	
	public Task saveTask(Task task);
	
	public List<Task> getAllTask();
	
	public void deleteTask(int id);
	
	public Task findByID(int id);
	
	public Task updateTask(Task task);
}
