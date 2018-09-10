package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the jobcategory database table.
 * 
 */
@Entity
@Table(name="jobcategory")
@NamedQuery(name="Jobcategory.findAll", query="SELECT j FROM JobCategory j")
public class JobCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)

		private Long id;

	@Column(name="job_category")

	private String jobcategory_name;

	//bi-directional many-to-one association to Job
@JsonBackReference (value="jobJobCategory")	@OneToMany(mappedBy="jobcategory")
	private List<Job> jobs;

	public JobCategory() {
	}


	public Long getId() {
		return this.id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getJobcategory_name() {
		return jobcategory_name;


	}

	
	public void setJobcategory_name(String jobcategory_name) {
		this.jobcategory_name = jobcategory_name;
	}

	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Job addJob(Job job) {
		getJobs().add(job);
		job.setJobcategory(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setJobcategory(null);

		return job;
	}

}
