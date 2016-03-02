package org.mikala.testqwondo.api.model;

import java.io.Serializable;

public class UserRole implements Serializable {

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
	public Role getRole(){
		if(id!=null) return 
				id.getRole();
		return null;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (!(obj instanceof UserRole)) {
			return false;
		}
		UserRole other = (UserRole) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	


}
