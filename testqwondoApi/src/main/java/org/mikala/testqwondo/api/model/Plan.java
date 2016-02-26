package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the plan database table.
 * 
 */
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Timestamp createtime;

	private String name;

	private Timestamp planedend;

	private Timestamp planedstart;

	private String status;

	private String system;

	private String systemversion;

	private String type;

	//bi-directional many-to-one association to User
	private User user;

	//bi-directional many-to-one association to Task
	private Set<Task> tasks;

	//bi-directional many-to-one association to Taskgroup
	private Set<Taskgroup> taskgroups;

	public Plan() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getPlanedend() {
		return this.planedend;
	}

	public void setPlanedend(Timestamp planedend) {
		this.planedend = planedend;
	}

	public Timestamp getPlanedstart() {
		return this.planedstart;
	}

	public void setPlanedstart(Timestamp planedstart) {
		this.planedstart = planedstart;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getSystemversion() {
		return this.systemversion;
	}

	public void setSystemversion(String systemversion) {
		this.systemversion = systemversion;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setPlan(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setPlan(null);

		return task;
	}

	public Set<Taskgroup> getTaskgroups() {
		return this.taskgroups;
	}

	public void setTaskgroups(Set<Taskgroup> taskgroups) {
		this.taskgroups = taskgroups;
	}

	public Taskgroup addTaskgroup(Taskgroup taskgroup) {
		getTaskgroups().add(taskgroup);
		taskgroup.setPlan(this);

		return taskgroup;
	}

	public Taskgroup removeTaskgroup(Taskgroup taskgroup) {
		getTaskgroups().remove(taskgroup);
		taskgroup.setPlan(null);

		return taskgroup;
	}

}