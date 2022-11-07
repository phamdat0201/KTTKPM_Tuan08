package com.se.StudentService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
	private String studentId;
	private String name;
	private int age;
	private Object mentor;
}
