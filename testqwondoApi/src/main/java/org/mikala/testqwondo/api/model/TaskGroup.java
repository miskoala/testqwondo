package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="task_groups")
public class TaskGroup extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Basic
	@Column(name="bugzilla_nr")
	private Integer bugzillaNr;

	@Basic
	@Column(length=50,nullable=false)
	@Size(min=2,max=50)
	@NotBlank
	private String name;

	@OneToMany(mappedBy="taskGroup",targetEntity=Task.class)
	private Set<Task> tasks;

	@ManyToOne(targetEntity=Plan.class,fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="plan_id")
	private Plan plan;

	@ManyToOne(targetEntity=TaskGroup.class,fetch=FetchType.LAZY)
	@JoinColumn(name="parent_task_group_id")
	private TaskGroup parentTaskGroup;

	@OneToMany(mappedBy="taskGroups", targetEntity=TaskGroup.class, fetch=FetchType.LAZY)
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