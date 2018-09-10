package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;



/**
 * The persistent class for the interview database table.
 * 
 */
@Entity
@NamedQuery(name="Interview.findAll", query="SELECT i FROM Interview i")
public class Interview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="interview_date")
	private Date interviewDate;

	@Column(name="interview_hour")
	private String interviewHour;

	@Column(name="interview_type")
	private String interviewType;

	//association to Person
		
		@ManyToOne
		private Person person;

	public Interview() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInterviewDate() {
		return this.interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	
	public String getInterviewHour() {
		return interviewHour;
	}

	public void setInterviewHour(String interviewHour) {
		this.interviewHour = interviewHour;
	}

	public String getInterviewType() {
		return this.interviewType;
	}

	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
}
