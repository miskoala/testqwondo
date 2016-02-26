package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the taskgroup database table.
 * 
 */
public class Taskgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Integer bugzillanr;

	private String name;

	//bi-directional many-to-one association to Task
	private Set<Task> tasks;

	//bi-directional many-to-one association to Plan
	private Plan plan;

	//bi-directional many-to-one association to Taskgroup
	private Taskgroup taskgroup;

	//bi-directional many-to-one association to Taskgroup
	private Set<Taskgroup> taskgroups;

	public Taskgroup() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBugzillanr() {
		return this.bugzillanr;
	}

	public void setBugzillanr(Integer bugzillanr) {
		this.bugzillanr = bugzillanr;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setTaskgroup(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setTaskgroup(null);

		return task;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Taskgroup getTaskgroup() {
		return this.taskgroup;
	}

	public void setTaskgroup(Taskgroup taskgroup) {
		this.taskgroup = taskgroup;
	}

	public Set<Taskgroup> getTaskgroups() {
		return this.taskgroups;
	}

	public void setTaskgroups(Set<Taskgroup> taskgroups) {
		this.taskgroups = taskgroups;
	}

	public Taskgroup addTaskgroup(Taskgroup taskgroup) {
		getTaskgroups().add(taskgroup);
		taskgroup.setTaskgroup(this);

		return taskgroup;
	}

	public Taskgroup removeTaskgroup(Taskgroup taskgroup) {
		getTaskgroups().remove(taskgroup);
		taskgroup.setTaskgroup(null);

		return taskgroup;
	}

}