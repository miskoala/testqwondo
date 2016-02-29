package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.util.Set;



public class TaskGroup extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer bugzillaNr;

	private String name;

	private Set<Task> tasks;

	private Plan plan;

	private TaskGroup parentTaskGroup;

	private Set<TaskGroup> taskGroups;

	public TaskGroup() {
	}

	public Integer getBugzillaNr() {
		return bugzillaNr;
	}

	public void setBugzillaNr(Integer bugzillaNr) {
		this.bugzillaNr = bugzillaNr;
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
		task.setTaskGroup(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setTaskGroup(null);

		return task;
	}
	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public TaskGroup getParentTaskGroup() {
		return parentTaskGroup;
	}

	public void setParentTaskGroup(TaskGroup parentTaskGroup) {
		this.parentTaskGroup = parentTaskGroup;
	}

	public Set<TaskGroup> getTaskGroups() {
		return taskGroups;
	}

	public void setTaskGroups(Set<TaskGroup> taskGroups) {
		this.taskGroups = taskGroups;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TaskGroup addTaskGroup(TaskGroup taskgroup) {
		getTaskGroups().add(taskgroup);
		taskgroup.setParentTaskGroup(this);

		return taskgroup;
	}

	public TaskGroup removeTaskgroup(TaskGroup taskgroup) {
		getTaskGroups().remove(taskgroup);
		taskgroup.setParentTaskGroup(null);
		return taskgroup;
	}

}