package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the person_jobproposal database table.
 * 
 */
@Embeddable
public class PersonJobProposalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="person_id", insertable=false, updatable=false)
	private Long personId;

	@Column(name="jobproposal_id", insertable=false, updatable=false)
	private Long jobproposalId;

	public PersonJobProposalPK() {
	}
	public Long getPersonId() {
		return this.personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public Long getJobproposalId() {
		return this.jobproposalId;
	}
	public void setJobproposalId(Long jobproposalId) {
		this.jobproposalId = jobproposalId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonJobProposalPK)) {
			return false;
		}
		PersonJobProposalPK castOther = (PersonJobProposalPK)other;
		return 
			this.personId.equals(castOther.personId)
			&& this.jobproposalId.equals(castOther.jobproposalId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.personId.hashCode();
		hash = hash * prime + this.jobproposalId.hashCode();
		
		return hash;
	}
}