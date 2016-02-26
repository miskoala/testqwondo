package org.mikala.testqwondo.api;

import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the users database table.
 * 
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String email;

	private String jabber;

	private String login;

	private String name;

	private String password;

	//bi-directional many-to-one association to Plan
	private Set<Plan> plans;

	//bi-directional many-to-one association to Result
	private Set<Result> results;

	//bi-directional many-to-one association to Task
	private Set<Task> tasks1;

	//bi-directional many-to-one association to Task
	private Set<Task> tasks2;

	//bi-directional many-to-many association to Role
	private Set<Role> roles;

	public User() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJabber() {
		return this.jabber;
	}

	public void setJabber(String jabber) {
		this.jabber = jabber;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Plan> getPlans() {
		return this.plans;
	}

	public void setPlans(Set<Plan> plans) {
		this.plans = plans;
	}

	public Plan addPlan(Plan plan) {
		getPlans().add(plan);
		plan.setUser(this);

		return plan;
	}

	public Plan removePlan(Plan plan) {
		getPlans().remove(plan);
		plan.setUser(null);

		return plan;
	}

	public Set<Result> getResults() {
		return this.results;
	}

	public void setResults(Set<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setUser(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setUser(null);

		return result;
	}

	public Set<Task> getTasks1() {
		return this.tasks1;
	}

	public void setTasks1(Set<Task> tasks1) {
		this.tasks1 = tasks1;
	}

	public Task addTasks1(Task tasks1) {
		getTasks1().add(tasks1);
		tasks1.setUser1(this);

		return tasks1;
	}

	public Task removeTasks1(Task tasks1) {
		getTasks1().remove(tasks1);
		tasks1.setUser1(null);

		return tasks1;
	}

	public Set<Task> getTasks2() {
		return this.tasks2;
	}

	public void setTasks2(Set<Task> tasks2) {
		this.tasks2 = tasks2;
	}

	public Task addTasks2(Task tasks2) {
		getTasks2().add(tasks2);
		tasks2.setUser2(this);

		return tasks2;
	}

	public Task removeTasks2(Task tasks2) {
		getTasks2().remove(tasks2);
		tasks2.setUser2(null);

		return tasks2;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}