package com.se.MentorService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Mentor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mentor {

	@Id
	@Column(name = "mentor_id")
	private String mentorId;
	private String name;
	private String Address;
}
