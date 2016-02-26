package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the result database table.
 * 
 */
public class Result implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Integer bugzillanr;

	private Timestamp createtime;

	private String description;

	private Boolean fixed;

	private String type;

	//bi-directional many-to-one association to Task
	private Task task;

	//bi-directional many-to-one association to User
	private User user;

	public Result() {
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

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getFixed() {
		return this.fixed;
	}

	public void setFixed(Boolean fixed) {
		this.fixed = fixed;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}