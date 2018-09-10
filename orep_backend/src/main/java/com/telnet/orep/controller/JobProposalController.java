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

import com.telnet.orep.services.JobProposalService;
import com.telnet.orep.services.PersonJobproposalService;
import com.telnet.orep.entities.JobProposal;

@RestController
@RequestMapping("/api")

public class JobProposalController {
	
	@Autowired
	private JobProposalService jobProposalService;
	@Autowired
	PersonJobproposalService Personjobservice;

	
	//Get All jobsProposal
	
			@GetMapping("/jobProposal/liste")
			public List<JobProposal> getJobsProposal(){
				return jobProposalService.getJobsProposal();	
			}
			
			@GetMapping("/jobProposalEm/liste")
			public List<JobProposal> getJobsEm(){
				return jobProposalService.getJobEmbauche();	
			}
			@GetMapping("/jobProposalSt/liste")
			public List<JobProposal> getJobStage(){
				return jobProposalService.getJobStage();	
			}
		//find by id
			@GetMapping("/jobProposal/{id}")
			public Optional<JobProposal> getJobProposal(@PathVariable Long id){
				return jobProposalService.find(id);
					
			}
			
			
		  
		// Delete jobProposal
			@DeleteMapping("/jobProposal/delete/{id}")
			public boolean deleteJobProposal(@PathVariable long id){
				jobProposalService.delete(id);
			 
				return true;
					}
			//add new jobProposal
			@PutMapping("/jobProposal/create")
			public JobProposal createJobProposal(@RequestBody JobProposal jobProposal){
				return jobProposalService.save(jobProposal);
			
					
			}
			//update job
			@PutMapping("/jobProposal/update")
			public JobProposal updateJobProposal( @RequestBody JobProposal jobProposal){
				return jobProposalService.save(jobProposal);
					
			}
			
			@GetMapping("/jobProposal/Orderedlist")
			public List<JobProposal> orderedList(){
				return jobProposalService.orderedList();	
			}
			@GetMapping("/jobProposal/testDragAndDrop/{id}")
			public Boolean testDragAndDrop(@PathVariable long id){
				JobProposal jobProposal= new JobProposal();
				jobProposal=jobProposalService.findId(id);
				if(jobProposal.getNumberOfPosition()>Personjobservice.CountAccepted(jobProposal.getId())) {
					return true;
				}
				return false;
			}
}










		