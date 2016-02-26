
package org.mikala.testqwondo.jpa.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * testqwondoDB.Plan 06/06/2013 07:45:45
 * 
 */
@Entity
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255, nullable = false)
	private String name;

	private String system;

	private String systemVersion;

	@Column(nullable = false)
	private Date createTime;
	
	@Enumerated(EnumType.STRING)
	private PlanType type;

	private String status;

	private Date planedStart;

	private Date planedEnd;

	@ManyToOne
	@JoinColumn(name = "created_by_id", nullable = false)
	private User createdBy;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "plan")
	private Set<TaskGroup> taskGroups = new LinkedHashSet<TaskGroup>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "plan")
	private Set<Task> tasks = new LinkedHashSet<Task>();

	protected Plan() {
		super();
	}

	public Plan(String name, String system, String systemVersion, Date createTime, PlanType type, String status,
			Date planedStart, Date planedEnd, User createdBy) {
		super();
		this.name = name;
		this.system = system;
		this.systemVersion = systemVersion;
		this.createTime = createTime;
		this.type = type;
		this.status = status;
		this.planedStart = planedStart;
		this.planedEnd = planedEnd;
		this.createdBy = createdBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public PlanType getType() {
		return type;
	}

	public void setType(PlanType type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getPlanedStart() {
		return planedStart;
	}

	public void setPlanedStart(Date planedStart) {
		this.planedStart = planedStart;
	}

	public Date getPlanedEnd() {
		return planedEnd;
	}

	public void setPlanedEnd(Date planedEnd) {
		this.planedEnd = planedEnd;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Set<TaskGroup> getTaskGroups() {
		return taskGroups;
	}

	public void setTaskGroups(Set<TaskGroup> taskGroups) {
		this.taskGroups = taskGroups;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).build();
	}
}
