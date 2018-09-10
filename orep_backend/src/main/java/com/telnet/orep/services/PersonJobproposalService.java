package com.telnet.orep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telnet.orep.dao.PersonJobproposalDao;
import com.telnet.orep.entities.Person;
import com.telnet.orep.entities.PersonJobProposal;
import com.telnet.orep.entities.PersonJobProposalPK;

@Service
public class PersonJobproposalService {
	@Autowired
	PersonJobproposalDao PersonJobRepository;

	public PersonJobProposal save(PersonJobProposal personjob)
	{  
		return PersonJobRepository.save(personjob);
		}
	public List<Person> accepted(Long id){
		return PersonJobRepository.accepted(id);
	}
	public List<Person> refused(Long id){
		return PersonJobRepository.refused(id);
	}
public List<PersonJobProposal> getPersonJobs()
	
	{ return PersonJobRepository.findAll();
		}
public int CountAccepted(Long id) {
	return PersonJobRepository.CountAccepted(id);
}
public Optional<PersonJobProposal> findById(PersonJobProposalPK id){
	return PersonJobRepository.findById(id);
}
public int testState(PersonJobProposalPK id){
	return PersonJobRepository.testState(id);
}
}

