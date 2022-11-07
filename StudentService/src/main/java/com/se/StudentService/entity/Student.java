package com.se.StudentService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

	@Id
	@Column(name = "student_id")
	private String studentId;
	private String name;
	private int age;
	@Column(name = "mentor_id")
	private String mentorId;
}
