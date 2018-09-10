package com.telnet.orep.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.telnet.orep.entities.JobProposal;


public interface JobProposalDao  extends JpaRepository<JobProposal, Long>  {
	@Query("select j from JobProposal j where j.statusJob='true' and j.type='Embauche'")
	 List<JobProposal> findjob();
	@Query("select j from JobProposal j where j.statusJob='true' and j.type='Stage'")
	 List<JobProposal> findstage();
	@Query("select j from JobProposal j  ORDER BY CASE WHEN j.statusJob ='true' THEN 1 ELSE 2 END, j.statusJob")
	 List<JobProposal> orderedList();
	@Query("select j from JobProposal j where j.id=:id")
	JobProposal findId(@Param("id") Long id);
	   
}

