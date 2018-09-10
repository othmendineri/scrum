package com.telnet.orep.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.telnet.orep.entities.JobCategory;

public interface JobCategoryDao extends JpaRepository<JobCategory, Long>{

}
