package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * The persistent class for the users database table.
 * 
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String login;
	
	private String name;

	private String email;

	private String jabber;

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

}