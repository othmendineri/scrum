package com.telnet.orep.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telnet.orep.dao.PersonDao;
import com.telnet.orep.entities.Person;
import com.telnet.orep.entities.PersonJobProposal;
import com.telnet.orep.entities.PersonJobProposalPK;
import com.telnet.orep.services.PersonJobproposalService;

@RestController
@RequestMapping("/api")
public class PersonJobproposalController {
	@Autowired
	PersonJobproposalService Personjobservice;
	@Autowired
	PersonDao persondao;
    
	

	@PutMapping("/personjob/create")
	public PersonJobProposal createPersonJob(@RequestBody PersonJobProposal Personjob){
	
		return Personjobservice.save(Personjob);
	}
	@PutMapping("/personjob/update")
	public PersonJobProposal updatePersonJob(@RequestBody PersonJobProposal Personjob){
	
		return Personjobservice.save(Personjob);
	}
	@GetMapping("/personjob/accpcandi/{id}")
	public List<Person> listAccepte(@PathVariable Long id){
		return Personjobservice.accepted(id);
	}
	@GetMapping("/personjob/refcandi/{id}")
	public List<Person> listRefused(@PathVariable Long id){
		return Personjobservice.refused(id);
	}
	@GetMapping("/personjob/countaccpcandi/{id}")
	public int CountAccepted(@PathVariable Long id){
		return Personjobservice.CountAccepted(id);
	}
	@GetMapping("/personjob/liste")
	public List<PersonJobProposal> getPersonJobProposal() {
		return Personjobservice.getPersonJobs();

	}
	@GetMapping("/personjob/{id}")
	public Optional<PersonJobProposal> findById(@PathVariable PersonJobProposalPK id){
		return Personjobservice.findById(id);
	}
	@GetMapping("/personjob/testState/{id}")
	public boolean testState(@PathVariable PersonJobProposalPK id){
		if(Personjobservice.testState(id)>0) {
			return true;
		}
		else
		{
			return false;
		}
	}
}
