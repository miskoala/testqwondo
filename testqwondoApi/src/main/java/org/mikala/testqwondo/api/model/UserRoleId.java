package org.mikala.testqwondo.api.model;

import java.io.Serializable;



public class UserRoleId implements Serializable {

	private static final long serialVersionUID = 8562517023633494407L;
	private Role role;
	private Long userId;

	public UserRoleId() {
	}

	public UserRoleId(Long userId, Role role) {
		this.role = role;
		this.userId = userId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRoleId))
			return false;
		UserRoleId castOther = (UserRoleId) other;

		return ((this.getRole() == castOther.getRole()) || (this.getRole() != null && castOther.getRole() != null
				&& this.getRole().equals(castOther.getRole()))) && (this.getUserId() == castOther.getUserId());
	}

/*	public int hashCode() {
		int result = 17;

		result = 37 * result + (getRole() == null ? 0 : this.getRole().hashCode());
		result = 37 * result + (int) this.getUserId();
		return result;
	}*/

}
