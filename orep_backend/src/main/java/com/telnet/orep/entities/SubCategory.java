package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subcategory database table.
 * 
 */
@Entity
@NamedQuery(name="Subcategory.findAll", query="SELECT s FROM SubCategory s")
public class SubCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="sbcategory_name")
	private String sbcategoryName;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="subcategory")
	private List<Question> questions;

	//bi-directional many-to-one association to Category
	@ManyToOne
	private Category category;

	public SubCategory() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSbcategoryName() {
		return this.sbcategoryName;
	}

	public void setSbcategoryName(String sbcategoryName) {
		this.sbcategoryName = sbcategoryName;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setSubcategory(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setSubcategory(null);

		return question;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
