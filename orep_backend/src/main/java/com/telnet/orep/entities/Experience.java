package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the experience database table.
 * 
 */
@Entity
@NamedQuery(name="Experience.findAll", query="SELECT e FROM Experience e")
public class Experience implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String company;

    private long duration;

	private String position;

	//bi-directional many-to-one association to Person
    @JsonBackReference(value="exp")
	@ManyToOne(fetch = FetchType.EAGER)
	private Person person;

	public Experience() {
	}
	public long getDuration() {
		return duration;
	}



	public void setDuration(long duration) {
		this.duration = duration;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}
	

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}



	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
