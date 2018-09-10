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

import com.telnet.orep.entities.Phase;
import com.telnet.orep.services.PhaseService;

@RestController
@RequestMapping("/api")
public class PhaseController {
	@Autowired
	PhaseService phaseService;
	
	//Get All phases
	@GetMapping("/phase/liste")
	public List<Phase> getPhases(){
		return phaseService.getPhases();	
	}
//find by id
	@GetMapping("/phase/{id}")
	public Optional<Phase> getPhase(@PathVariable Long id){
		return phaseService.find(id);
			
	}
// Deletephase	
	@DeleteMapping("/phase/delete/{id}")
	public boolean deletePhase(@PathVariable long id){
		phaseService.delete(id);
	 
		return true;
			}
	//add new phase
	@PutMapping("/phase/create")
	public Phase createPhase(@RequestBody Phase phase){
		return phaseService.save(phase);
	
			
	}
	//update phase
	@PutMapping("/phase/update")
	public Phase updatePhase( @RequestBody Phase phase){
		return phaseService.save(phase);
			
	}
	

}
