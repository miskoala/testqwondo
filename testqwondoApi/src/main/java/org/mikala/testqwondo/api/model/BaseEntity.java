package org.mikala.testqwondo.api.model;

import java.util.Date;

public abstract class BaseEntity {
	private Long id;
	private Date createdTime;
	private Date modifiedTime;
	private User createdBy;
	private User modifiedBy;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date lastModifiedTime) {
		this.modifiedTime = lastModifiedTime;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public User getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(User lastModifiedBy) {
		this.modifiedBy = lastModifiedBy;
	}
}
