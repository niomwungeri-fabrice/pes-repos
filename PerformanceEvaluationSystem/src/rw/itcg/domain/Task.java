package rw.itcg.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 10:02:55 AM
 */
@Entity
public class Task extends GenericDomain {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taskId;
	private String taskType;
	private String taskDescription;


	@OneToMany(mappedBy = "task")
	private Set<TaskDone> employeeTask = new HashSet<>();

	public Set<TaskDone> getEmployeeTask() {
		return employeeTask;
	}

	public void setEmployeeTask(Set<TaskDone> employeeTask) {
		this.employeeTask = employeeTask;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Long getTaskId() {
		return taskId;
	}

}
