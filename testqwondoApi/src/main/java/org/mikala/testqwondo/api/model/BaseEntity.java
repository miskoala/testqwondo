package org.mikala.testqwondo.api.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Basic
	@Column(name="created_time", nullable=false)
	private Date createdTime;
	@Basic
	@Column(name="modified_time", nullable=true)
	private Date modifiedTime;
	@ManyToOne(optional=false, fetch=FetchType.EAGER, targetEntity=User.class)
	@JoinColumn(name="created_by_id")
	private User createdBy;
	@ManyToOne(optional=true, fetch=FetchType.EAGER, targetEntity=User.class)
	@JoinColumn(name="modified_by_id")
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
