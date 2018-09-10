package com.telnet.orep.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telnet.orep.entities.Interview;



public interface InterviewDao extends JpaRepository<Interview, Long> {

}
