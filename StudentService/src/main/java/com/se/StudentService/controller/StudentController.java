package com.se.StudentService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.se.StudentService.entity.Student;
import com.se.StudentService.entity.StudentDto;
import com.se.StudentService.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	@Autowired
    private RestTemplate restTemplate;
 
	
//	@RequestMapping(path = "students")
//	public List<Student> getAllStudents(){
//		return studentRepository.findAll();
//	}
	@GetMapping("/students")
    public List<StudentDto> getAll2() {
        List<StudentDto> studentDtos = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            Object o = restTemplate.getForObject("http://localhost:2222/mentors/" + student.getMentorId(), Object.class);
            studentDtos.add(new StudentDto(student.getStudentId(), student.getName(), student.getAge(), o));
        }
        return studentDtos;
    }
}
