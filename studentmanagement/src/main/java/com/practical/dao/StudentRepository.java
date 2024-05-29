package com.practical.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practical.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
