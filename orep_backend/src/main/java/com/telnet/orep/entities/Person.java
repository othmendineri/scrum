package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the person database table.
 * 
 */
@Entity

@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String address;

	@Column(name = "bank_account")
	private String bankAccount;

	private String cin;

	private String city;

	private String civilstatue;

	@Column(name = "contract_type")
	private String contractType;

	private String contry;

	@Column(name = "creation_date")
	private String creationDate;

	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	private String email;

	private String firstname;

	private String gender;

	private String institute;
	private String pfe;
	private Long year;
	private String diplome;
	private float salary;
	@Column(name = "type_stage")
	private String typeStage;

	public String getTypeStage() {
		return typeStage;
	}

	public void setTypeStage(String typeStage) {
		this.typeStage = typeStage;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	private String formation;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPfe() {
		return pfe;
	}

	public void setPfe(String pfe) {
		this.pfe = pfe;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	private String lastname;

	@Temporal(TemporalType.DATE)
	@Column(name = "passport_expiration_date")
	private Date passportExpirationDate;

	@Column(name = "passport_number")
	private String passportNumber;

	@Column(name = "password")
	private String password;

	private Long phone;

	private String pic;

	private String placeofbirth;

	@Column(name = "postal_code")
	private String postalCode;

	private String recommandation;

	private String skills;

	private String username;
	private String active;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_phase")
	private Phase phase;

	@OneToMany(mappedBy = "person")
	private List<Document> documents;

	@OneToMany(mappedBy = "person")
	private List<Experience> experiences;

	// bi-directional many-to-one association to Department

	@ManyToOne

	private Department department;

	// bi-directional many-to-one association to Job

	@ManyToOne
	private Job job;

	// bi-directional many-to-one association to Rank

	@ManyToOne
	private Rank rank;

	// bi-directional many-to-one association to Role

	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;

	// bi-directional many-to-many association to Interview
	@JsonBackReference(value="personinterview")
	@OneToMany(mappedBy = "person")
	private List<Interview> interviews;
	private int rating;
	// bi-directional many-to-one association to PersonJobproposal

	@OneToMany(mappedBy = "person")
	private List<PersonJobProposal> personJobproposals;
	@Column(name = "type_candidat")
	private String typeCandidat;

	public Person() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCivilstatue() {
		return this.civilstatue;
	}

	public void setCivilstatue(String civilstatue) {
		this.civilstatue = civilstatue;
	}

	public String getContractType() {
		return this.contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getContry() {
		return this.contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getInstitute() {
		return this.institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getPassportExpirationDate() {
		return this.passportExpirationDate;
	}

	public void setPassportExpirationDate(Date passportExpirationDate) {
		this.passportExpirationDate = passportExpirationDate;
	}

	public String getPassportNumber() {
		return this.passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPlaceofbirth() {
		return this.placeofbirth;
	}

	public void setPlaceofbirth(String placeofbirth) {
		this.placeofbirth = placeofbirth;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getRecommandation() {
		return this.recommandation;
	}

	public void setRecommandation(String recommandation) {
		this.recommandation = recommandation;
	}

	public String getSkills() {
		return this.skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setPerson(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setPerson(null);

		return document;
	}

	public List<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public Experience addExperience(Experience experience) {
		getExperiences().add(experience);
		experience.setPerson(this);

		return experience;
	}

	public Experience removeExperience(Experience experience) {
		getExperiences().remove(experience);
		experience.setPerson(null);

		return experience;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Rank getRank() {
		return this.rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Interview> getInterviews() {
		return this.interviews;
	}

	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}

	public List<PersonJobProposal> getPersonJobproposals() {
		return this.personJobproposals;
	}

	public void setPersonJobproposals(List<PersonJobProposal> personJobproposals) {
		this.personJobproposals = personJobproposals;
	}

	public PersonJobProposal addPersonJobproposal(PersonJobProposal personJobproposal) {
		getPersonJobproposals().add(personJobproposal);
		personJobproposal.setPerson(this);

		return personJobproposal;
	}

	public PersonJobProposal removePersonJobproposal(PersonJobProposal personJobproposal) {
		getPersonJobproposals().remove(personJobproposal);
		personJobproposal.setPerson(null);

		return personJobproposal;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getTypeCandidat() {
		return typeCandidat;
	}

	public void setTypeCandidat(String typeCandidat) {
		this.typeCandidat = typeCandidat;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}