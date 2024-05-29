package com.practical.services;

import java.util.List;

import com.practical.entity.Student;


public interface StudentService {
	
	public Student saveStudent(Student std);
	
	public List<Student> getAllStudent();
		
	public void deleteStudent(int id);
	
	public Student findByID(int id);

	
	public Student updateStudent(Student student);
}
