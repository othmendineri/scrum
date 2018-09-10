package com.telnet.orep.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telnet.orep.entities.*;

public interface RoleDao extends JpaRepository<Role, Long> {
	 @Query("select r from Role r ")
	  List<Role> findAndSort( Sort sort);

}
