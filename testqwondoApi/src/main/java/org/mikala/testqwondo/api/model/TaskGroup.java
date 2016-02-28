package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the taskgroup database table.
 * 
 */
public class TaskGroup extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Integer bugzillanr;

	private String name;

	private Set<Task> tasks;

	private Plan plan;

	private TaskGroup taskgroup;

	private Set<TaskGroup> taskgroups;

	public TaskGroup() {
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

	public TaskGroup getTaskgroup() {
		return this.taskgroup;
	}

	public void setTaskgroup(TaskGroup taskgroup) {
		this.taskgroup = taskgroup;
	}

	public Set<TaskGroup> getTaskgroups() {
		return this.taskgroups;
	}

	public void setTaskgroups(Set<TaskGroup> taskgroups) {
		this.taskgroups = taskgroups;
	}

	public TaskGroup addTaskgroup(TaskGroup taskgroup) {
		getTaskgroups().add(taskgroup);
		taskgroup.setTaskgroup(this);

		return taskgroup;
	}

	public TaskGroup removeTaskgroup(TaskGroup taskgroup) {
		getTaskgroups().remove(taskgroup);
		taskgroup.setTaskgroup(null);

		return taskgroup;
	}

}