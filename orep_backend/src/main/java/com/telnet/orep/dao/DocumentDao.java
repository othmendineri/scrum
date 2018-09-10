package com.telnet.orep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telnet.orep.entities.Document;
@Repository
public interface DocumentDao  extends JpaRepository<Document,Long>{

}
