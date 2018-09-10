package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the jobproposal database table.
 * 
 */
@Entity
@Table(name="jobproposal")
@NamedQuery(name="JobProposal.findAll", query="SELECT j FROM JobProposal j")
public class JobProposal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="end_internship")
	private Date endInternship;

	@Column(name="job_proposal_name")
	private String jobProposalName;

	@Column(name="number_of_position")
	private Integer numberOfPosition;

	@Temporal(TemporalType.DATE)
	@Column(name="start_internship")
	private Date startInternship;

	@Column(name="status_job")
	private String statusJob;
   
	//bi-directional many-to-one association to Job
	@ManyToOne
	private Job job;

	//bi-directional many-to-one association to Project
	@ManyToOne
	private Project project;
	//bi-directional many-to-one association to Phase
	
		@OneToMany(mappedBy="jobproposal")
		private List<Phase> phases;

	//bi-directional many-to-one association to PersonJobproposal
	@OneToMany(mappedBy="jobproposal")
	private List<PersonJobProposal> personJobproposals;
    private String type;
	public JobProposal() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndInternship() {
		return this.endInternship;
	}

	public void setEndInternship(Date endInternship) {
		this.endInternship = endInternship;
	}

	public String getJobProposalName() {
		return this.jobProposalName;
	}

	public void setJobProposalName(String jobProposalName) {
		this.jobProposalName = jobProposalName;
	}

	public Integer getNumberOfPosition() {
		return this.numberOfPosition;
	}

	public void setNumberOfPosition(Integer numberOfPosition) {
		this.numberOfPosition = numberOfPosition;
	}

	public Date getStartInternship() {
		return this.startInternship;
	}

	public void setStartInternship(Date startInternship) {
		this.startInternship = startInternship;
	}

	public String getStatusJob() {
		return this.statusJob;
	}

	public void setStatusJob(String statusJob) {
		this.statusJob = statusJob;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<PersonJobProposal> getPersonJobproposals() {
		return this.personJobproposals;
	}

	public void setPersonJobproposals(List<PersonJobProposal> personJobproposals) {
		this.personJobproposals = personJobproposals;
	}

	public PersonJobProposal addPersonJobproposal(PersonJobProposal personJobproposal) {
		getPersonJobproposals().add(personJobproposal);
		personJobproposal.setJobproposal(this);

		return personJobproposal;
	}

	public PersonJobProposal removePersonJobproposal(PersonJobProposal personJobproposal) {
		getPersonJobproposals().remove(personJobproposal);
		personJobproposal.setJobproposal(null);

		return personJobproposal;
	}
	public List<Phase> getPhases() {
		return phases;
	}

	public void setPhases(List<Phase> phases) {
		this.phases = phases;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}