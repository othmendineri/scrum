package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the rating database table.
 * 
 */
@Entity
@NamedQuery(name="Rating.findAll", query="SELECT r FROM Rating r")
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idrating;

	@Column(name="star_number")
	private Integer starNumber;

	
	public Rating() {
	}

	public Integer getIdrating() {
		return this.idrating;
	}

	public void setIdrating(Integer idrating) {
		this.idrating = idrating;
	}

	public Integer getStarNumber() {
		return this.starNumber;
	}

	public void setStarNumber(Integer starNumber) {
		this.starNumber = starNumber;
	}

	

}
