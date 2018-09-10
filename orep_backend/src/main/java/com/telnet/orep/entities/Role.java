package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
@Column(name="role_name")
	private String name;
	
 private String description;
 
//bi-directional many-to-one association to Person
    @JsonBackReference
	@OneToMany(mappedBy="role")
	private List<Person> persons;
	
	//bi-directional many-to-many association to Permission
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="role_permission"
		, joinColumns={
			@JoinColumn(name="role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="permission_id")
			}
		)
	
	private List<Permission> permissions;

	

	public Role() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getRole_name() {
		return name;
	}

	public void setRole_name(String role_name) {
		this.name = role_name;
	}

	public List<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setRole(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setRole(null);

		return person;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}