package org.mikala.testqwondo.api.model;

import java.io.Serializable;

public class UserRole implements Serializable{

	private static final long serialVersionUID = 1L;
	private UserRoleId id;
	private User user;

	public UserRole() {
		super();
	}
	public UserRole(UserRoleId id, User user) {
		this.id = id;
		this.user = user;
	}
	public UserRoleId getId() {
		return id;
	}
	public void setId(UserRoleId id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	



}
