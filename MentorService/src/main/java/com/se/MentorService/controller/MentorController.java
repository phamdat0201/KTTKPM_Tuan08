package com.se.MentorService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.MentorService.entity.Mentor;
import com.se.MentorService.repository.MentorRepository;

@RestController
public class MentorController {

	@Autowired
	MentorRepository studentRepository;
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@GetMapping(path = "mentors")
	public List<Mentor> getAllMentor(){
		return studentRepository.findAll();
	}
	@GetMapping("/mentors/{id}")
    public Mentor getOne(@PathVariable String id) throws JsonProcessingException {
        Object value = redisTemplate.opsForValue().get("mentor:" + id);
        if (value != null) {
            Mentor mentor = objectMapper.readValue((String) value, Mentor.class);
            System.out.println("object from Redis: "+mentor);
            return mentor;
        }
        return studentRepository.findById(id).get();
    }
}
