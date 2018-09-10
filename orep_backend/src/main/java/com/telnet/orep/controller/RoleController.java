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


import com.telnet.orep.entities.Role;
import com.telnet.orep.services.*;

@RestController
@RequestMapping("/api")
public class RoleController {
	@Autowired
	private RoleService roleservice;
	@GetMapping("/role/listeSorted")
	public List<Role> getRolesSorted(){
		return roleservice.findAndSort();	
	}

	
	//Get All roles
			@GetMapping("/role/liste")
			public List<Role> getRoles(){
				return roleservice.getRoles();	
			}
		//find by id
			@GetMapping("/role/{id}")
			public Optional<Role> getRole(@PathVariable Long id){
				return roleservice.find(id);
					
			}
		// Delete role	
			@DeleteMapping("/role/delete/{id}")
			public boolean deleteRole(@PathVariable long id){
				roleservice.delete(id);
			 
				return true;
					}
			//add new role
			@PutMapping("/role/create")
			public Role createRole(@RequestBody Role role){
				return roleservice.save(role);
			
					
			}
			//update role
			@PutMapping("/role/update")
			public Role updateRole( @RequestBody Role role){
				return roleservice.save(role);
					
			}

}
