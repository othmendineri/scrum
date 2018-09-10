package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the site database table.
 * 
 */
@Entity
@NamedQuery(name="Site.findAll", query="SELECT s FROM Site s")
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="site_name")
	private String siteName;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="site")
	private List<Project> projects;

	public Site() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSiteName() {
		return this.siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setSite(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setSite(null);

		return project;
	}

}
