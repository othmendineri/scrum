package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the job database table.
 * 
 */
@Entity
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="job_name")
	private String jobName;

	//bi-directional many-to-one association to Jobcategory
	
	@ManyToOne
	private JobCategory jobcategory;

	//bi-directional many-to-one association to Jobproposal

	@JsonBackReference (value="jobjobProposal")
    @OneToMany(mappedBy="job")
	private List<JobProposal> jobproposals;

	//bi-directional many-to-one association to Person
@JsonBackReference(value="jobperson")
@OneToMany(mappedBy="job")
	private List<Person> persons;

	public Job() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public JobCategory getJobcategory() {
		return this.jobcategory;
	}

	public void setJobcategory(JobCategory jobcategory) {
		this.jobcategory = jobcategory;
	}

	public List<JobProposal> getJobproposals() {
		return this.jobproposals;
	}

	public void setJobproposals(List<JobProposal> jobproposals) {
		this.jobproposals = jobproposals;
	}

	public JobProposal addJobproposal(JobProposal jobproposal) {
		getJobproposals().add(jobproposal);
		jobproposal.setJob(this);

		return jobproposal;
	}

	public JobProposal removeJobproposal(JobProposal jobproposal) {
		getJobproposals().remove(jobproposal);
		jobproposal.setJob(null);

		return jobproposal;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setJob(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setJob(null);

		return person;
	}

}
