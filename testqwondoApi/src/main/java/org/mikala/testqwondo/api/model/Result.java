package org.mikala.testqwondo.api.model;

import java.io.Serializable;

public class Result extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer bugzillaNr;

	private String description;

	private Boolean fixed;

	private String type;

	private Task task;

	public Result() {
	}

	public Integer getBugzillaNr() {
		return this.bugzillaNr;
	}

	public void setBugzillaNr(Integer bugzillanr) {
		this.bugzillaNr = bugzillanr;
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

}