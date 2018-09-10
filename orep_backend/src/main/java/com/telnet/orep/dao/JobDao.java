package com.telnet.orep.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.telnet.orep.entities.Job;

public interface JobDao extends JpaRepository<Job, Long> {

}

