package org.mikala.testqwondo.api.model;

import java.io.Serializable;

public class UserRolePK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private Role role;
	public UserRolePK() {
		super();
	}
	
	public UserRolePK(User user, Role role) {
		super();
		this.user = user;
		this.role = role;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
