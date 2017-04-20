package rw.itcg.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 10:26:14 AM
 */
@Entity
public class TaskDone extends GenericDomain {

	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Column(name = "employee_task_id", unique = true)
	private long taskDoneId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_Id")
	private Employee employees;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "task_Id")
	private Task task;

	public Employee getEmployees() {
		return employees;
	}

	public void setTaskDoneId(long taskDoneId) {
		this.taskDoneId = taskDoneId;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	private double itemsDone;

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public double getItemsDone() {
		return itemsDone;
	}

	public void setItemsDone(double itemsDone) {
		this.itemsDone = itemsDone;
	}

	public long getTaskDoneId() {
		return taskDoneId;
	}

}
