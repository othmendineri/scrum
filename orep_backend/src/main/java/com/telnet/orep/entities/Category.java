package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String category;

	//bi-directional many-to-one association to Subcategory
	@OneToMany(mappedBy="category")
	private List<SubCategory> subcategories;

	public Category() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<SubCategory> getSubcategories() {
		return this.subcategories;
	}

	public void setSubcategories(List<SubCategory> subcategories) {
		this.subcategories = subcategories;
	}

	public SubCategory addSubcategory(SubCategory subcategory) {
		getSubcategories().add(subcategory);
		subcategory.setCategory(this);

		return subcategory;
	}

	public SubCategory removeSubcategory(SubCategory subcategory) {
		getSubcategories().remove(subcategory);
		subcategory.setCategory(null);

		return subcategory;
	}

}