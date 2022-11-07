package com.se.StudentService.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@GetMapping("/students2")
    public List<StudentDto> getAll2() {
        List<StudentDto> studentDtos = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            Object o = restTemplate.getForObject("http://localhost:2222/mentors/" + student.getMentorId(), Object.class);
            studentDtos.add(new StudentDto(student.getStudentId(), student.getName(), student.getAge(), o));
        }
        return studentDtos;
    }
	@GetMapping("/students")
    public List<Map<String, Object>> getAll() {
        List<Student> students = studentRepository.findAll();
        List<Map<String, Object>> maps = new ArrayList<>();
        for (Student student : students) {
        	HashMap<String, Object> map = new HashMap<>();
            Object o = restTemplate.getForObject("http://localhost:2222/mentors/" + student.getMentorId(), Object.class);
            map.put("studentId", student.getStudentId());
            map.put("name", student.getName());
            map.put("age", student.getAge());
            map.put("mentor", o);
            maps.add(map);
        }
        return maps;
    }
}
