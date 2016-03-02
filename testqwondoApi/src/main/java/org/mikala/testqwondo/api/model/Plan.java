package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.mikala.testqwondo.api.model.enums.PlanStatus;
import org.mikala.testqwondo.api.model.enums.PlanType;


public class Plan extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	private Date planedEnd;

	private Date planedStart;

	private PlanStatus status;

	private String system;

	private String systemVersion;

	private PlanType type;

	private Set<Task> tasks;

	private Set<TaskGroup> taskGroups;

	public Plan() {
	}

	public Plan(String name, String system, String systemversion, Date createtime, PlanType type, PlanStatus status,
			Date planedstart, Date planedend, User createdBy) {
		super();
		this.name = name;
		this.system = system;
		this.systemVersion = systemversion;
		setCreatedTime(createtime);
		this.type = type;
		this.status = status;
		this.planedStart = planedstart;
		this.planedEnd = planedend;
		setCreatedBy(createdBy);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPlanedEnd() {
		return planedEnd;
	}

	public void setPlanedEnd(Date planedEnd) {
		this.planedEnd = planedEnd;
	}

	public Date getPlanedStart() {
		return planedStart;
	}

	public void setPlanedStart(Date planedStart) {
		this.planedStart = planedStart;
	}

	public PlanStatus getStatus() {
		return status;
	}

	public void setStatus(PlanStatus status) {
		this.status = status;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getSystemVersion() {
		return systemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}

	public PlanType getType() {
		return type;
	}

	public void setType(PlanType type) {
		this.type = type;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public Set<TaskGroup> getTaskGroups() {
		return this.taskGroups;
	}

	public void setTaskGroups(Set<TaskGroup> taskgroups) {
		this.taskGroups = taskgroups;
	}

	public TaskGroup addTaskgroup(TaskGroup taskgroup) {
		getTaskGroups().add(taskgroup);
		taskgroup.setPlan(this);

		return taskgroup;
	}

	public TaskGroup removeTaskgroup(TaskGroup taskgroup) {
		getTaskGroups().remove(taskgroup);
		taskgroup.setPlan(null);

		return taskgroup;
	}

}