
package pl.zetokatowice.testqwondo.jpa.model;

import java.util.Date;
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
 *  testqwondoDB.Task
 *  03/26/2013 15:14:38
 * 
 */
@Entity
public class Task {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private String description;
    private String status;
    private Date startTime;
    private Date endTime;
    private Long duration;
    
    
    
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;
    
    @ManyToOne
    @JoinColumn(name = "start_user_id")
    private User startUser;
    
    @ManyToOne
    @JoinColumn(name = "end_user_id")
    private User endUser;
    
    @ManyToOne
    @JoinColumn(name = "taskgroup_id")
    private TaskGroup taskGroup;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
    private Set<Result> results = new LinkedHashSet<Result>();

    
    
    protected Task() {
		super();
	}

	public Task(Long id, String symbol, String description, String status, Date startTime, Date endTime,
			Long duration, Plan plan, User startUser, User endUser, TaskGroup taskGroup, Set<Result> results) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.description = description;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.plan = plan;
		this.startUser = startUser;
		this.endUser = endUser;
		this.taskGroup = taskGroup;
		this.results = results;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }



    public User getStartUser() {
		return startUser;
	}

	public void setStartUser(User startUser) {
		this.startUser = startUser;
	}

	public User getEndUser() {
		return endUser;
	}

	public void setEndUser(User endUser) {
		this.endUser = endUser;
	}

	public TaskGroup getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(TaskGroup taskGroup) {
        this.taskGroup = taskGroup;
    }

    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }

}
