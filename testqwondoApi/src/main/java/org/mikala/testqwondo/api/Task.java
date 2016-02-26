package org.mikala.testqwondo.api;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the task database table.
 * 
 */
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String description;

	private Long duration;

	private Timestamp endtime;

	private Timestamp starttime;

	private String status;

	private String symbol;

	//bi-directional many-to-one association to Result
	private Set<Result> results;

	//bi-directional many-to-one association to Plan
	private Plan plan;

	//bi-directional many-to-one association to Taskgroup
	private Taskgroup taskgroup;

	//bi-directional many-to-one association to User
	private User user1;

	//bi-directional many-to-one association to User
	private User user2;

	public Task() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
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

	public Taskgroup getTaskgroup() {
		return this.taskgroup;
	}

	public void setTaskgroup(Taskgroup taskgroup) {
		this.taskgroup = taskgroup;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}