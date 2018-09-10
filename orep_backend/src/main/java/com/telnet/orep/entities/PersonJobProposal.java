package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the person_jobproposal database table.
 * 
 */
@Entity
@Table(name="person_jobproposal")
@NamedQuery(name="PersonJobproposal.findAll", query="SELECT p FROM PersonJobProposal p")
public class PersonJobProposal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonJobProposalPK id;

	//bi-directional many-to-one association to Jobproposal
	@JsonBackReference(value="jobproposal")
	@ManyToOne
	@JoinColumn(name="jobproposal_id", insertable = false, updatable = false)
	private JobProposal jobproposal;

	//bi-directional many-to-one association to Person
	@JsonBackReference(value="person")
	@ManyToOne
	@JoinColumn(name="person_id", insertable = false, updatable = false)
	private Person person;


	
    private String state;
	public PersonJobProposal() {
	}

	public PersonJobProposalPK getId() {
		return this.id;
	}

	public void setId(PersonJobProposalPK id) {
		this.id = id;
	}

	public JobProposal getJobproposal() {
		return this.jobproposal;
	}

	public void setJobproposal(JobProposal jobproposal) {
		this.jobproposal = jobproposal;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
