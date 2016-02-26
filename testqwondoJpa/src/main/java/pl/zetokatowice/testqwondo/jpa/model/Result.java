
package pl.zetokatowice.testqwondo.jpa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 *  testqwondoDB.Result
 *  03/20/2013 22:01:22
 * 
 */
@Entity
public class Result {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String description;
    private Integer bugzillaNr;
    private Date createTime;
    private Boolean fixed;
    @ManyToOne
    @JoinColumn(name="created_by_id")
    private User createdBy;
    @ManyToOne
    @JoinColumn(name="task_id")
    private Task task;

    
    
    protected Result() {
		super();
		// TODO Auto-generated constructor stub
	}
    

	public Result(Long id, String type, String description, Integer bugzillaNr, Date createTime, Boolean fixed,
			User createdBy, Task task) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.bugzillaNr = bugzillaNr;
		this.createTime = createTime;
		this.fixed = fixed;
		this.createdBy = createdBy;
		this.task = task;
	}


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBugzillaNr() {
        return bugzillaNr;
    }

    public void setBugzillaNr(Integer bugzillaNr) {
        this.bugzillaNr = bugzillaNr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getFixed() {
        return fixed;
    }

    public void setFixed(Boolean fixed) {
        this.fixed = fixed;
    }

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

}
