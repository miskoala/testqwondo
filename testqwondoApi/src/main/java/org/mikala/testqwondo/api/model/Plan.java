package org.mikala.testqwondo.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.mikala.testqwondo.api.model.enums.PlanStatus;
import org.mikala.testqwondo.api.model.enums.PlanType;

@Entity
@Table(name = "plans")
public class Plan extends BaseEntity implements Serializable {
  @Transient
  private static final long serialVersionUID = 1L;

  @Basic
  @Column(length = 100, nullable = false, unique = true)
  @NotBlank
  private String name;
  @Basic
  @Column(length = 100, nullable = true)
  @Size(max = 100)
  private String system;
  @Basic
  @Column(length = 100, nullable = true, name = "system_version")
  @Size(max = 100)
  private String systemVersion;
  @Basic
  @Column(length = 2, nullable = false)
  @Enumerated(EnumType.STRING)
  private PlanType type;
  @Basic
  @Column(length = 2, nullable = false)
  @Enumerated(EnumType.STRING)
  private PlanStatus status;
  @Basic
  @Column(name = "planed_start", nullable = true)
  private Date planedStart;
  @Basic
  @Column(name = "planed_end", nullable = true)
  private Date planedEnd;
  @OneToMany(mappedBy = "plan", targetEntity = Task.class)
  private Set<Task> tasks;
  @OneToMany(mappedBy = "plan", targetEntity = TaskGroup.class)
  private Set<TaskGroup> taskGroups;

  public Plan() {}

  public Plan(final String planName, final PlanType planType, final PlanStatus planStatus,
      final User planCreatedBy) {
    super();
    this.name = planName;
    this.type = planType;
    this.status = planStatus;
    setCreatedBy(planCreatedBy);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getPlanedEnd() {
    return planedEnd;
  }

  public void setPlanedEnd(Date planedEnd) {
    this.planedEnd = planedEnd;
  }

  public Date getPlanedStart() {
    return planedStart;
  }

  public void setPlanedStart(Date planedStart) {
    this.planedStart = planedStart;
  }

  public PlanStatus getStatus() {
    return status;
  }

  public void setStatus(PlanStatus status) {
    this.status = status;
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

  public PlanType getType() {
    return type;
  }

  public void setType(PlanType type) {
    this.type = type;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
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

  public Set<TaskGroup> getTaskGroups() {
    return this.taskGroups;
  }

  public void setTaskGroups(Set<TaskGroup> taskgroups) {
    this.taskGroups = taskgroups;
  }

  public TaskGroup addTaskgroup(TaskGroup taskgroup) {
    getTaskGroups().add(taskgroup);
    taskgroup.setPlan(this);

    return taskgroup;
  }

  public TaskGroup removeTaskgroup(TaskGroup taskgroup) {
    getTaskGroups().remove(taskgroup);
    taskgroup.setPlan(null);

    return taskgroup;
  }

}
