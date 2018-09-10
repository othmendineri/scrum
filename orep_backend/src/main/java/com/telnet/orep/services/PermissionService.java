package com.telnet.orep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telnet.orep.dao.*;
import com.telnet.orep.entities.*;
@Service
public class PermissionService {
	@Autowired
	PermissionDao permissionRepository;
	public Permission save(Permission permission)
	{
		return permissionRepository.save(permission);}

	public Permission update(Permission permission)
	{
		return permissionRepository.save(permission);}
	public Optional<Permission> find(Long id) {
		return permissionRepository.findById(id);
	}
	public List<Permission> getPermissions()
	{ return permissionRepository.findAll();
		}
	public boolean delete(Long id) {
		permissionRepository.deleteById(id);
		 return true;
	}
}
