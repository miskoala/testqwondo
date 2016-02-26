
package org.mikala.testqwondo.jpa.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *  testqwondoDB.TaskGroup
 *  03/26/2013 15:14:38
 * 
 */
@Entity
public class TaskGroup {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer bugzillaNr;
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

   
    
    @ManyToOne
    @JoinColumn(name = "parent_taskgroup_id")
    private TaskGroup parentTaskGroup;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentTaskGroup")
    private Set<TaskGroup> taskGroups = new LinkedHashSet<TaskGroup>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taskGroup")
    private Set<Task> tasks = new LinkedHashSet<Task>();

    
    
    protected TaskGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskGroup(Long id, String name, Integer bugzillaNr, Plan plan, TaskGroup parentTaskGroup,
			Set<TaskGroup> taskGroups, Set<Task> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.bugzillaNr = bugzillaNr;
		this.plan = plan;
		this.parentTaskGroup = parentTaskGroup;
		this.taskGroups = taskGroups;
		this.tasks = tasks;
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

    public Integer getBugzillaNr() {
        return bugzillaNr;
    }

    public void setBugzillaNr(Integer bugzillaNr) {
        this.bugzillaNr = bugzillaNr;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }



    public TaskGroup getParentTaskGroup() {
		return parentTaskGroup;
	}

	public void setParentTaskGroup(TaskGroup parentTaskGroup) {
		this.parentTaskGroup = parentTaskGroup;
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

}
