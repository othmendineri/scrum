package com.telnet.orep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.telnet.orep.dao.RoleDao;

import com.telnet.orep.entities.Role;
@Service
public class RoleService {
@Autowired
RoleDao roleRepository;
public Role save(Role role)
{
	return roleRepository.save(role);}

public Role update(Role role)
{
	return roleRepository.save(role);}
public Optional<Role> find(Long id) {
	return roleRepository.findById(id);
}
public List<Role> getRoles()
{ return roleRepository.findAll();
	}
public boolean delete(Long id) {
	 roleRepository.deleteById(id);
	 return true;
}

public List<Role> findAndSort(){
	 return roleRepository.findAndSort(new Sort("name"));
}
}



