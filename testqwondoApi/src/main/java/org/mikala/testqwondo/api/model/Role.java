package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the role database table.
 * 
 */
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	private String role;

	private String description;

	//bi-directional many-to-many association to User
	private Set<User> users;

	public Role() {
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}