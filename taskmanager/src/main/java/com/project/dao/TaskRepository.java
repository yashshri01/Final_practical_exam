package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Task;


public interface TaskRepository extends JpaRepository<Task, Integer>{

}
