package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.Task;
import com.project.services.TaskService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class TaskController {
	
	private TaskService taskservice;

	@Autowired
	public TaskController(TaskService taskservice) {
		super();
		this.taskservice = taskservice;
	}
	
	//Create Operation
	@GetMapping("/create")
	public String saveTask(Model model) {
		model.addAttribute("task", new Task());
		return "addTask";
	}
	
	@PostMapping("/savetask")
	public String getstatus(@Valid @ModelAttribute("task") Task task, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return "addTask";
		}
		taskservice.saveTask(task);
		return "redirect:/read";
	}
	
	//Read Operation
	@GetMapping("/read")
	public String displayAllTask(Model model){
		List<Task> tasklist =taskservice.getAllTask();
		model.addAttribute("task", tasklist );
		return "display";
	}
	
	
	//Delete Operation
		@PostMapping("/task/delete")
		public String deleteTask(@RequestParam("id") int taskID, Model model) {
			taskservice.deleteTask(taskID);
			return "redirect:/read";
		}
	
		
	//Update Operation
		@GetMapping("/task/update")
		public String updateStu(@RequestParam("id") int id, Model model) {
			Task task =taskservice.findByID(id);
			model.addAttribute("task", task);
			return "updateForm";		
		}
		
		@PostMapping("/saveupdate")
		public String getUpdate(@Valid @ModelAttribute("task") Task task, BindingResult bindresult) {
			System.out.println(bindresult.getAllErrors());
			if(bindresult.hasErrors()) {
				return "updateForm";
			}
			taskservice.updateTask(task);
			return "redirect:/read";
			
		}	
		
	//HomePage
		@GetMapping("/home")
	public String backToHome() {
		return "Home";
		
	}
	
}
