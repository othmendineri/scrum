package com.telnet.orep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telnet.orep.entities.Experience;
@Repository
public interface ExperienceDao extends JpaRepository<Experience, Long> {

}
