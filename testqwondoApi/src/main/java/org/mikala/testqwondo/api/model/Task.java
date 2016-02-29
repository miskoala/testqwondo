package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;



public class Task extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	private Long duration;

	private Timestamp endTime;

	private Timestamp startTime;

	private String status;

	private String symbol;

	private Set<Result> results;

	private Plan plan;

	private TaskGroup taskGroup;

	private User startedUser;

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

	public Timestamp getEndtime() {
		return this.endTime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endTime = endtime;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp starttime) {
		this.startTime = starttime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
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