package com.telnet.orep.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.telnet.orep.entities.Person;


public interface PersonDao extends JpaRepository<Person, Long> {
	@Query("select p from Person p where p.username is not null")
	public List<Person> findByUsername();
	@Query("select p from Person p join PersonJobProposal j on p.id=j.person.id where p.phase.id is null and p.type='Candidat'and j.state='en cours' and j.jobproposal.id=:id ORDER BY CASE WHEN j.state ='en cours' THEN 1 ELSE 2 END, j.state ")
	public List<Person> test_phase(@Param("id") Long id);
	@Query("select p from Person p join PersonJobProposal j on p.id=j.person.id where p.type='Employé' and j.jobproposal.id=:id ")
	public List<Person> listAccepte(@Param("id") Long id);
	
	public Optional<Person> findByCin(String cin);
	@Query("select p from Person p where p.type='Employé'")
	public List<Person> findByType(); 
	@Query("select p from Person p where p.type='Candidat' and p.typeCandidat='Embauche'")
	public List<Person> findByTypeEmbauche(); 
	@Query("select p from Person p where p.type='Candidat' and p.typeCandidat='Stage'")
	public List<Person> findByTypeStage(); 


}

