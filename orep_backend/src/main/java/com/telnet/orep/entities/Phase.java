package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the phase database table.
 * 
 */
@Entity
@NamedQuery(name="Phase.findAll", query="SELECT p FROM Phase p")
public class Phase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to Person

	@OneToMany(mappedBy="phase")
	private List<Person> persons;

	//bi-directional many-to-one association to Jobproposal
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="id_jobproposal")
	private JobProposal jobproposal;

	public Phase() {
	}

	
	public Long getId() {
		return this.id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setPhase(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setPhase(null);

		return person;
	}

	public JobProposal getJobproposal() {
		return this.jobproposal;
	}

	public void setJobproposal(JobProposal jobproposal) {
		this.jobproposal = jobproposal;
	}

}