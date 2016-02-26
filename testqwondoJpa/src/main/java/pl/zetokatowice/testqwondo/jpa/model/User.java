
package pl.zetokatowice.testqwondo.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *  testqwondoDB.Users
 *  06/06/2013 07:45:45
 * 
 */
@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@Column(length=50,nullable=false,unique=true)
    private String login;
	@Column(length=100,nullable=false)
    private String password;
    private String name;
    @Column(length=200,nullable=false,unique=true)
    private String email;
    private String jabber;
    
    @ManyToMany
    @JoinTable(name="user_roles", 
          joinColumns=@JoinColumn(name="user_id"),
          inverseJoinColumns=@JoinColumn(name="role"))
    private Set<Role> roles = new HashSet<Role>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
    private Set<Result> results = new HashSet<Result>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "startUser")
    private Set<Task> tasksForStartedUserId = new HashSet<Task>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "endUser")
    private Set<Task> tasksForEndedUserId = new HashSet<Task>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
    private Set<Plan> plans = new HashSet<Plan>();

    
    
    protected User() {
		super();
		// TODO Auto-generated constructor stub
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

 

    public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }

    public Set<Task> getTasksForStartedUserId() {
        return tasksForStartedUserId;
    }

    public void setTasksForStartedUserId(Set<Task> tasksForStartedUserId) {
        this.tasksForStartedUserId = tasksForStartedUserId;
    }

    public Set<Task> getTasksForEndedUserId() {
        return tasksForEndedUserId;
    }

    public void setTasksForEndedUserId(Set<Task> tasksForEndedUserId) {
        this.tasksForEndedUserId = tasksForEndedUserId;
    }

    public Set<Plan> getPlans() {
        return plans;
    }

    public void setPlans(Set<Plan> plans) {
        this.plans = plans;
    }

}
