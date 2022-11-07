package com.se.MentorService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.MentorService.entity.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, String>{

}
