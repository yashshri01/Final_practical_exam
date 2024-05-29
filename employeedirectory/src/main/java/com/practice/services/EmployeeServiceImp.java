package com.practice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.EmployeeRepository;
import com.practice.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	private EmployeeRepository empRepo;
	
	@Autowired
	public EmployeeServiceImp(EmployeeRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> getAll =empRepo.findAll();
		return getAll;
	}

	@Override
	public Employee findByID(int id) {
		Optional<Employee> byId = empRepo.findById(id);
		Employee emp =byId.get();
		return emp;
	}

	@Override
	public void deleteEmployee(int id) {
		empRepo.deleteById(id);
	}

}
