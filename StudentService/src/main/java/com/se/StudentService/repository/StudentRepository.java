package com.se.StudentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.StudentService.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

}
