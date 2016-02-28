package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the plan database table.
 * 
 */
public class Plan extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date createtime;

	private String name;

	private Date planedend;

	private Date planedstart;

	private String status;

	private String system;

	private String systemversion;

	private PlanType type;

	private User user;

	private Set<Task> tasks;

	private Set<TaskGroup> taskgroups;

	public Plan() {
	}

	public Plan(String name, String system, String systemversion, Date createtime, PlanType type, String status,
			Date planedstart, Date planedend, User user) {
		super();
		this.name = name;
		this.system = system;
		this.systemversion = systemversion;
		this.createtime = createtime;
		this.type = type;
		this.status = status;
		this.planedstart = planedstart;
		this.planedend = planedend;
		this.user = user;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPlanedend() {
		return this.planedend;
	}

	public void setPlanedend(Date planedend) {
		this.planedend = planedend;
	}

	public Date getPlanedstart() {
		return this.planedstart;
	}

	public void setPlanedstart(Date planedstart) {
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

	public PlanType getType() {
		return this.type;
	}

	public void setType(PlanType type) {
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

	public Set<TaskGroup> getTaskgroups() {
		return this.taskgroups;
	}

	public void setTaskgroups(Set<TaskGroup> taskgroups) {
		this.taskgroups = taskgroups;
	}

	public TaskGroup addTaskgroup(TaskGroup taskgroup) {
		getTaskgroups().add(taskgroup);
		taskgroup.setPlan(this);

		return taskgroup;
	}

	public TaskGroup removeTaskgroup(TaskGroup taskgroup) {
		getTaskgroups().remove(taskgroup);
		taskgroup.setPlan(null);

		return taskgroup;
	}

}