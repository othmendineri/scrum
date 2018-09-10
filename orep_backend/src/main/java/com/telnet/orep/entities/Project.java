package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;


import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="project_name")
	private String projectName;

	//bi-directional many-to-one association to Jobproposal
	
	@OneToMany(mappedBy="project")
	private List<JobProposal> jobproposals;

	//bi-directional many-to-one association to Activity
	@ManyToOne
	private Activity activity;

	//bi-directional many-to-one association to Site
	@ManyToOne
	private Site site;

	public Project() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<JobProposal> getJobproposals() {
		return this.jobproposals;
	}

	public void setJobproposals(List<JobProposal> jobproposals) {
		this.jobproposals = jobproposals;
	}

	public JobProposal addJobproposal(JobProposal jobproposal) {
		getJobproposals().add(jobproposal);
		jobproposal.setProject(this);

		return jobproposal;
	}

	public JobProposal removeJobproposal(JobProposal jobproposal) {
		getJobproposals().remove(jobproposal);
		jobproposal.setProject(null);

		return jobproposal;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
