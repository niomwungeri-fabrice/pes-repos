package rw.itcg.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rw.itcg.domain.Company;
import rw.itcg.domain.Employee;
import rw.itcg.domain.Job;
import rw.itcg.service.EmployeeService;

/**
 * @author NIYOMWUNGERI Apr 24, 2017, 10:00:56 PM
 */
@Component
@ManagedBean
public class TaskControll {
	private String keyWord;
	@Autowired
	private EmployeeService empService;
	private List<Employee> getAllemployee;
	private List<Company> companyList;
	private List<Job> jobList;
	private boolean disable = true;

	private Double itemsDone;

	public TaskControll() {
		getAllemployee = new ArrayList<Employee>();
		jobList = new ArrayList<Job>();
		companyList = new ArrayList<Company>();
		disable = true;
	}

	public List<String> autoCompleteOwner(String query) {

		List<String> empNames = new ArrayList<String>();
		List<Employee> allEmp = empService.findAll();

		for (Employee emp : allEmp) {
			if (emp.getFirstname().contains(query) || emp.getEmployeeId().contains(query)
					|| emp.getLastname().contains(query)) {
				empNames.add(emp.getEmployeeId() + "|" + emp.getFirstname());
				Employee e = empService.findByUsername(emp.getEmployeeId());
				if (getAllemployee.equals(e)) {
					getAllemployee.remove(e);
				}
			}
		}
		return empNames;
	}

	public void onItemSelect(SelectEvent event) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Item Selected", event.getObject().toString()));
	}

	public List<Employee> getGetAllemployee() {
		return getAllemployee;
	}

	public void setGetAllemployee(List<Employee> getAllemployee) {
		this.getAllemployee = getAllemployee;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Double getItemsDone() {
		return itemsDone;
	}

	public void setItemsDone(Double itemsDone) {
		this.itemsDone = itemsDone;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}
}
