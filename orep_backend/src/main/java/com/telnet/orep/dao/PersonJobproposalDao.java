package com.telnet.orep.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.telnet.orep.entities.Person;
import com.telnet.orep.entities.PersonJobProposal;
import com.telnet.orep.entities.PersonJobProposalPK;

public interface PersonJobproposalDao extends JpaRepository<PersonJobProposal,Long>{
	@Query("select p.person from  PersonJobProposal p where p.state='accepté' and p.jobproposal.id=:id ")
	public List<Person> accepted(@Param("id") Long id);
	@Query("select count(*) from  PersonJobProposal p where p.state='accepté' and p.jobproposal.id=:id ")
	public int CountAccepted(@Param("id") Long id);
	public  Optional<PersonJobProposal> findById(PersonJobProposalPK id);
	@Query("select count(*) from  PersonJobProposal p where p.state='refusé' and p.id=:id ")
	public  int testState(@Param("id") PersonJobProposalPK id);
	@Query("select p.person from  PersonJobProposal p where p.state='refusé' and p.jobproposal.id=:id ")
	public List<Person> refused(@Param("id") Long id);
	 

}
