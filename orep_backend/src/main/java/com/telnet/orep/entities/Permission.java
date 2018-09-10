package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the permission database table.
 * 
 */
@Entity
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")

public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String permission_name;

	//bi-directional many-to-one association to Module
		@ManyToOne
		@JoinColumn(name="module_id")
		
		private Module module;
		
	public Module getModule() {
			return module;
		}

		public void setModule(Module module) {
			this.module = module;
		}

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="permissions",fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Role> roles;

	public Permission() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getPermissionName() {
		return permission_name;
	}

	public void setPermissionName(String permissionName) {
		this.permission_name = permissionName;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}