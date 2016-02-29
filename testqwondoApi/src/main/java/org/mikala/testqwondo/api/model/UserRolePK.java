package org.mikala.testqwondo.api.model;

import java.io.Serializable;

public class UserRolePK implements Serializable{
	private Long userId;
	private Role role;
	public UserRolePK() {
		super();
	}
	public UserRolePK(Long userId, Role role) {
		super();
		this.userId = userId;
		this.role = role;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
