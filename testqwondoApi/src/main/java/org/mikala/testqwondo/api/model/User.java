package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


public class User implements Serializable {
	

	private static final long serialVersionUID = -8526367903243161996L;
	
	
	private Long id;

	@NotBlank
	@Size(min=2,max=20)
	private String login;
	
	@NotBlank
	@Size(min=2,max=200)
	private String name;
	
	@NotBlank
	@Size(min=5,max=200)
	private String email;

	@Size(max=200)
	private String jabber;

	@NotBlank
	@Size(max=50)
	private String password;
	
	private Set<UserRole> userRoles;

	public User() {
	}
	public User(String login, String password, String name, String email, String jabber) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.email = email;
		this.jabber = jabber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJabber() {
		return jabber;
	}
	public void setJabber(String jabber) {
		this.jabber = jabber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public UserRole addUserRole(UserRole userRole) {
		if(getUserRoles()==null){
			setUserRoles(new LinkedHashSet<UserRole>());
		}
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		if(getUserRoles()==null){
			//TODO co by tu zwrocic?
			return userRole;
		}
		getUserRoles().remove(userRole);
		userRole.setUser(null);
		return userRole;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jabber == null) ? 0 : jabber.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userRoles == null) ? 0 : userRoles.hashCode());
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
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (jabber == null) {
			if (other.jabber != null) {
				return false;
			}
		} else if (!jabber.equals(other.jabber)) {
			return false;
		}
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (userRoles == null) {
			if (other.userRoles != null) {
				return false;
			}
		} else if (!userRoles.equals(other.userRoles)) {
			return false;
		}
		return true;
	}
	
	

}