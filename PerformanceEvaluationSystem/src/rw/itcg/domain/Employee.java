package rw.itcg.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 8:51:25 AM
 */
@Entity
public class Employee extends GenericDomain {

	private static final long serialVersionUID = 1L;
	private String employeeId;
	private String firstname;
	private String lastname;
	private String phoneNumber;
	private Date hiredDate = new Date();

	@OneToMany(mappedBy = "employees")
	private Set<TaskDone> taskList = new HashSet<>();

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public Set<TaskDone> getTaskList() {
		return taskList;
	}

	public void setTaskList(Set<TaskDone> taskList) {
		this.taskList = taskList;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getHiredDate() {
		return hiredDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
