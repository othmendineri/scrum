package com.telnet.orep.services;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telnet.orep.dao.PersonDao;
import com.telnet.orep.entities.Person;

@Service
public class PersonService {
@Autowired
PersonDao personRepository;
public Person save(Person person)
{
	return personRepository.save(person);
	}

public Person update(Person person)
{
	return personRepository.save(person);}
public Optional<Person> find(Long id) {
	return personRepository.findById(id);
}

public List<Person> getPersons()
{ return personRepository.findAll();
	}
//get person by username

public List <Person> getPerson()
{ return  personRepository.findByUsername();
}

public Optional<Person> getpersonCin(String cin) {
	return personRepository.findByCin(cin);
	
}
//get person by type

public List <Person> getPersonEm()
{ return  personRepository.findByType();
}
//get person by type_candidat embauche 
public List <Person> getPersonCandidatEm()
{ return  personRepository.findByTypeEmbauche();
}

//get person by type_candidat embauche 
public List <Person> getPersonCandidatSt()
{ return  personRepository.findByTypeStage();
}

public boolean delete(Long id) {
	 personRepository.deleteById(id);
	 return true;
}
public List<Person> test_phase(Long id)
{
	return personRepository.test_phase(id);
}
public List<Person> listAccepte(Long id){
	return personRepository.listAccepte(id);
}
}





