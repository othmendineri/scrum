package com.telnet.orep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telnet.orep.entities.Experience;
import com.telnet.orep.services.ExperienceService;

@RestController
@RequestMapping("/api")
public class ExperienceController {
	@Autowired
private ExperienceService experienceserice;



@GetMapping("/experience/liste")
public List<Experience> getModules(){
	return experienceserice.getexperience();	
}
}
