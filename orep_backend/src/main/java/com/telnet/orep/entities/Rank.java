package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rank database table.
 * 
 */
@Entity
@NamedQuery(name="Rank.findAll", query="SELECT r FROM Rank r")
public class Rank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="rank_name")
	private String rankName;

	private double salary;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="rank")
	private List<Person> persons;

	public Rank() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRankName() {
		return this.rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setRank(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setRank(null);

		return person;
	}

}