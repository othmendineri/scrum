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

import com.telnet.orep.entities.Module;
import com.telnet.orep.entities.Permission;
import com.telnet.orep.services.*;

@RestController
@RequestMapping("/api")
public class ModuleController {
	@Autowired
	private ModuleService moduleservice;
	
	//Get All module
	@GetMapping("/module/liste")
	public List<Module> getModules(){
		return moduleservice.getModules();	
	}
//find by id
	@GetMapping("/module/{id}")
	public Optional<Module> getModule(@PathVariable Long id){
		return moduleservice.find(id);
			
	}
	@GetMapping("/modulePermission/{id}")
	public List<Permission> getModulePermission(@PathVariable Long id){
		return moduleservice.getModulePermission(id);
			
	}
// Delete module	
	@DeleteMapping("/module/delete/{id}")
	public boolean deleteModule(@PathVariable long id){
		moduleservice.delete(id);
	 
		return true;
			}
	//add new Module
	@PutMapping("/module/create")
	public Module createModule(@RequestBody Module module){
		return moduleservice.save(module);
	
			
	}
	//update module
	@PutMapping("/module/update")
	public Module updateModule( @RequestBody Module module){
		return moduleservice.save(module);
			
	}

}
