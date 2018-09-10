package com.telnet.orep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telnet.orep.entities.Interview;
import com.telnet.orep.services.InterviewService;

@RestController
@RequestMapping("/api")
public class InterviewController {
	@Autowired
	private InterviewService interviewservice;
	
	@PutMapping("/interview/create")
	public Interview createInterview(@RequestBody Interview interview){
		return interviewservice.save(interview);
	
			
	}
	@GetMapping("/interview/liste")
	public List<Interview> getInterview(){
		return interviewservice.getinterview();	
	}
	
}