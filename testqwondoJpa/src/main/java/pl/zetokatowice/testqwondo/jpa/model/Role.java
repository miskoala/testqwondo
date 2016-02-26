
package pl.zetokatowice.testqwondo.jpa.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


/**
 *  testqwondoDB.Role
 *  03/20/2013 22:01:22
 * 
 */
@Entity
public class Role {
	@Id
    private String role;
    private String description;
    @ManyToMany(mappedBy="roles")
    private Set<User> users = new LinkedHashSet<User>();
    
    
    
	protected Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String role, String description, Set<User> users) {
		super();
		this.role = role;
		this.description = description;
		this.users = users;
	}

	public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}



}
