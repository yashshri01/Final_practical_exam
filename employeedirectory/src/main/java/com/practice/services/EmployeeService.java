package com.practice.services;

import java.util.List;

import com.practice.entity.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee emp);
	
	public Employee updateEmployee(Employee emp);
	
	public List<Employee> getAllEmployee();
	
	public Employee findByID(int id);
	
	public void deleteEmployee(int id);
}
