package org.mikala.testqwondo.api.model;

import java.io.Serializable;

import org.mikala.testqwondo.api.model.enums.Role;



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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UserRoleId)) {
			return false;
		}
		UserRoleId other = (UserRoleId) obj;
		if (role != other.role) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}



}
