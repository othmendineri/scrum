package com.telnet.orep.controller;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.telnet.orep.entities.Document;
import com.telnet.orep.entities.Experience;
import com.telnet.orep.entities.Person;
import com.telnet.orep.entities.PersonJobProposal;
import com.telnet.orep.entities.PersonJobProposalPK;
import com.telnet.orep.services.DocumentService;
import com.telnet.orep.services.ExperienceService;
import com.telnet.orep.services.PersonJobproposalService;
import com.telnet.orep.services.PersonService;

@RestController
@RequestMapping("/api")

public class PersonController {

	@Autowired
	private PersonService personService;
	@Autowired
	private ExperienceService experience;
	@Autowired
	private DocumentService document;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private PersonJobproposalService personJobService;

	// Get All persons

	@GetMapping("/person/liste")
	public List<Person> getPersons() {
		return personService.getPersons();
	}

	// find by id
	@GetMapping("/person/{id}")
	public Optional<Person> getPerson(@PathVariable Long id) {
		return personService.find(id);

	}

	@GetMapping("/person/cin/{cin}")
	public Optional<Person> getcin(@PathVariable String cin) {
		System.out.println("controller" + personService.getpersonCin(cin).get().getId());
		return personService.getpersonCin(cin);
	}

	// find by username
	@GetMapping("/person/liste/user")
	public List<Person> getPersonUser() {
		return personService.getPerson();

	}

	// Delete person
	@DeleteMapping("/person/delete/{id}")
	public boolean deletePerson(@PathVariable long id) {
		personService.delete(id);

		return true;
	}

	// add new person
	@PutMapping("/person/create")
	public void createPerson(@RequestBody PersonJobProposal personjobPro) {
		PersonJobProposalPK personPk = new PersonJobProposalPK();
		PersonJobProposal personjob = new PersonJobProposal();
		if ("Candidat".equals(personjobPro.getPerson().getType())) {
			if (personjobPro.getPerson().getExperiences() == null) {
				Person createPerson = personService.save(personjobPro.getPerson());
				personPk.setPersonId(createPerson.getId());
				personPk.setJobproposalId(personjobPro.getJobproposal().getId());
				personjob.setId(personPk);
				personjob.setPerson(createPerson);
				personjob.setJobproposal(personjobPro.getJobproposal());
				personjob.setState("en cours");
				personJobService.save(personjob);
				for (Document doc : personjobPro.getPerson().getDocuments()) {
					doc.setPerson(createPerson);
					document.save(doc);

				}

			} else {
				Person createPerson = personService.save(personjobPro.getPerson());
				personPk.setPersonId(createPerson.getId());
				personPk.setJobproposalId(personjobPro.getJobproposal().getId());
				personjob.setId(personPk);
				personjob.setPerson(createPerson);
				personjob.setJobproposal(personjobPro.getJobproposal());
				personjob.setState("en cours");
				personJobService.save(personjob);
				for (Experience exp : personjobPro.getPerson().getExperiences()) {
					exp.setPerson(createPerson);
					experience.save(exp);

				}
				for (Document doc : personjobPro.getPerson().getDocuments()) {
					doc.setPerson(createPerson);
					document.save(doc);

				}
			}

		} else {
			if (personjobPro.getPerson().getPassword() != null) {
				if (personjobPro.getPerson().getExperiences() == null) {
					personjobPro.getPerson()
							.setPassword(bCryptPasswordEncoder.encode(personjobPro.getPerson().getPassword()));
					Person createPerson = personService.save(personjobPro.getPerson());
					for (Document doc : personjobPro.getPerson().getDocuments()) {
						doc.setPerson(createPerson);
						document.save(doc);

					}
				} else {
					personjobPro.getPerson()
							.setPassword(bCryptPasswordEncoder.encode(personjobPro.getPerson().getPassword()));
					Person createPerson = personService.save(personjobPro.getPerson());
					for (Experience exp : personjobPro.getPerson().getExperiences()) {
						exp.setPerson(createPerson);
						experience.save(exp);

					}
					for (Document doc : personjobPro.getPerson().getDocuments()) {
						doc.setPerson(createPerson);
						document.save(doc);

					}
				}

			} else {
				if (personjobPro.getPerson().getExperiences() != null) {
					Person createPerson = personService.save(personjobPro.getPerson());
					for (Experience exp : personjobPro.getPerson().getExperiences()) {
						exp.setPerson(createPerson);
						experience.save(exp);

					}
					for (Document doc : personjobPro.getPerson().getDocuments()) {
						doc.setPerson(createPerson);
						document.save(doc);

					}
				} else {
					Person createPerson = personService.save(personjobPro.getPerson());
					for (Document doc : personjobPro.getPerson().getDocuments()) {
						doc.setPerson(createPerson);
						document.save(doc);

					}
				}

			}

		}
	}

	// find by type
	@GetMapping("/person/liste/employe")
	public List<Person> getPersonEm() {
		return personService.getPersonEm();

	}

	// fin by type candidat embauche
	@GetMapping("/person/liste/candidat/embauche")
	public List<Person> getPersonCandidatEm() {
		return personService.getPersonCandidatEm();

	}

	// fin by type candidat stage
	@GetMapping("/person/liste/candidat/stage")
	public List<Person> getPersonCandidatSt() {
		return personService.getPersonCandidatSt();

	}

	// update person
	@PutMapping("/person/update")
	public Person updatePerson(@RequestBody Person person) {
		return personService.save(person);

	}

	@GetMapping("/person/nouveaucandi/{id}")
	public List<Person> test_phase(@PathVariable Long id) {
		return personService.test_phase(id);
	}

	@GetMapping("/person/accpcandi/{id}")
	public List<Person> listAccepte(@PathVariable Long id) {
		return personService.listAccepte(id);
	}

}
