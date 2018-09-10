package com.telnet.orep.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the module database table.
 * 
 */
@Entity
@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="module_name")
	private String moduleName;

	//bi-directional many-to-one association to Permission
	@OneToMany(mappedBy="module")
	@JsonBackReference
	private List<Permission> permissions;

	public Module() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public Permission addPermission(Permission permission) {
		getPermissions().add(permission);
		permission.setModule(this);

		return permission;
	}

	public Permission removePermission(Permission permission) {
		getPermissions().remove(permission);
		permission.setModule(null);

		return permission;
	}

}
