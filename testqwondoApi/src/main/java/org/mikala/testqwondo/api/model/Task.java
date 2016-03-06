package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.sql.Timestamp;
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
import org.mikala.testqwondo.api.model.enums.TaskStatus;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Basic
	@Column(columnDefinition = "text",nullable=false)
	@NotBlank
	private String description;

	@Basic
	private Long duration;

	@Basic
	@Column(name = "end_time")
	private Timestamp endTime;

	@Basic
	@Column(name = "start_time")
	private Timestamp startTime;

	@Basic
	private TaskStatus status;

	@Basic
	@Column(length = 50)
	@Size(max=50)
	private String symbol;

	@ManyToOne(targetEntity = Plan.class, fetch = FetchType.LAZY,optional=false)
	@JoinColumn(name = "plan_id")
	private Plan plan;

	@OneToMany(mappedBy = "task", targetEntity = Result.class)
	private Set<Result> results;

	@ManyToOne(targetEntity=TaskGroup.class,fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="task_group_id")
	private TaskGroup taskGroup;

	@ManyToOne(targetEntity=User.class,fetch=FetchType.LAZY)
	@JoinColumn(name="started_user_id")
	private User startedUser;

	@ManyToOne(targetEntity=User.class,fetch=FetchType.LAZY)
	@JoinColumn(name="ended_user_id")
	private User endedUser;

	public Task() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDuration() {
		return this.duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endtime) {
		this.endTime = endtime;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp starttime) {
		this.startTime = starttime;
	}

	public TaskStatus getStatus() {
		return this.status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Set<Result> getResults() {
		return this.results;
	}

	public void setResults(Set<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setTask(this);
		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setTask(null);
		return result;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public TaskGroup getTaskGroup() {
		return this.taskGroup;
	}

	public void setTaskGroup(TaskGroup taskGroup) {
		this.taskGroup = taskGroup;
	}

	public User getStartedUser() {
		return this.startedUser;
	}

	public void setStartedUser(User startedUser) {
		this.startedUser = startedUser;
	}

	public User getEndedUser() {
		return this.endedUser;
	}

	public void setEndedUser(User endedUser) {
		this.endedUser = endedUser;
	}

}