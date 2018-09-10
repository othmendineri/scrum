package com.telnet.orep.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telnet.orep.services.JobService;

import com.telnet.orep.entities.Job;

@RestController
@RequestMapping("/api")

public class JobController {
	
	@Autowired
	private JobService jobService;

	
	
	
	
	//Get All jobs
	
			@GetMapping("/job/liste")
			public List<Job> getJobs(){
				return jobService.getJobs();	
			}
		//find by id
			@GetMapping("/job/{id}")
			public Optional<Job> getJob(@PathVariable Long id){
				return jobService.find(id);
					
			}
			
			
		  
		// Delete job
			@DeleteMapping("/job/delete/{id}")
			public boolean deleteJob(@PathVariable long id){
				jobService.delete(id);
			 
				return true;
					}
			//add new job
			@PutMapping("/job/create")
			
			public Job createJob(@RequestBody Job job){
			
				return jobService.save(job);
			
					
			}
			//update job
			@PutMapping("/job/update")
			public Job updateJob( @RequestBody Job job){
				return jobService.save(job);
					
			}
			

}










		