package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.entity.Employee;
import com.practice.services.EmployeeService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class EmployeeController {

	private EmployeeService empservice;
	
	@Autowired
	public EmployeeController(EmployeeService empservice) {
		super();
		this.empservice = empservice;
	}

	//Create Operation
	@GetMapping("/create")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String getStatus(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return "addEmployee";
		}
		empservice.saveEmployee(employee);
		return "redirect:/read";
	}
	
	//Delete Operation
	@PostMapping("/employee/delete")
	public String deleteEmp(@RequestParam("id") int id, Model model) {
		empservice.deleteEmployee(id);
		return "redirect:/read";
	}
	
	
	//Read Operation
	@GetMapping("/read")
	public String displayAllEmp(Model model) {
		List<Employee> empList = empservice.getAllEmployee();
		model.addAttribute("employee",empList);
		return "display";
	}
	
	//Update Operation
	@GetMapping("/employee/update")
	public String updateStu(@RequestParam("id") int id, Model model) {
		Employee employee =empservice.findByID(id);
		model.addAttribute("employee", employee);
		return "updateForm";		
	}
	
	@PostMapping("/saveupdate")
	public String getUpdate(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindresult) {
		System.out.println(bindresult.getAllErrors());
		if(bindresult.hasErrors()) {
			return "updateForm";
		}
		empservice.updateEmployee(employee);
		return "redirect:/read";
		
	}
	
	//Home Page
		@GetMapping("/home")
		public String backToHome() {
			return "Home";
			
		}
}
