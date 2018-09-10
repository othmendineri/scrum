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

import com.telnet.orep.entities.JobCategory;
import com.telnet.orep.services.JobCategoryService;



@RestController
@RequestMapping("/api")
public class JobCategoryController {

	
	@Autowired
	private JobCategoryService jobCategoryService;
	//Get All jobsCategory
	
	@GetMapping("/jobCategory/liste")
	public List<JobCategory> getJobsCategory(){
		return jobCategoryService.getJobCategories();	
	}
//find by id
	@GetMapping("/jobCategory/{id}")
	public Optional<JobCategory> getJobCategory(@PathVariable Long id){
		return jobCategoryService.find(id);
			
	}
	
	
  
// Delete jobCategory
	@DeleteMapping("/jobCategory/delete/{id}")
	public boolean deleteJobCategory(@PathVariable long id){
		jobCategoryService.delete(id);
	 
		return true;
			}
	//add new jobCategory
	@PutMapping("/jobCategory/create")
	public JobCategory createJobCategory(@RequestBody JobCategory jobCategory){
		return jobCategoryService.save(jobCategory);
	
			
	}
	//update job
	@PutMapping("/jobCategory/update")
	public JobCategory updateJobCategory( @RequestBody JobCategory jobCategory){
		return jobCategoryService.save(jobCategory);
			
	}
	

}














