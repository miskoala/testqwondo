package org.mikala.testqwondo.api.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.mikala.testqwondo.api.model.enums.ResultType;
@Entity
@Table(name="results")
public class Result extends BaseEntity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;

	@Basic
	@Column(name="bugzilla_nr")
	private Integer bugzillaNr;
	@Basic
	@Column(columnDefinition="text")
	private String description;
	@Basic
	private Boolean fixed;
	@Basic
	@Column(length=20)
	@Enumerated(EnumType.STRING)
	private ResultType type;
	@ManyToOne(targetEntity=Task.class,fetch=FetchType.LAZY,optional=false)
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

	public ResultType getType() {
		return this.type;
	}

	public void setType(ResultType type) {
		this.type = type;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}