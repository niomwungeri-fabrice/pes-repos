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
import rw.itcg.domain.Project;
import rw.itcg.service.CompanyService;
import rw.itcg.service.EmployeeService;
import rw.itcg.service.ProjectService;

/**
 * @author NIYOMWUNGERI Apr 24, 2017, 10:00:56 PM
 */
@Component
@ManagedBean
public class TaskControll {
	private String keyWord;
	@Autowired
	private EmployeeService empService;
	@Autowired
	private CompanyService compService;
	@Autowired
	private ProjectService jobService;

	private String selectedCompany;
	private String selectedJob;
	private List<Employee> getAllemployee;
	private boolean disable = true;
	private Double itemsDone;

	public TaskControll() {
		getAllemployee = new ArrayList<Employee>();
		disable = true;
	}

	public List<Company> getAllcompany() {
		return compService.findAll();
	}

	public List<Project> getAlljob() {
		return jobService.findAll();
	}

	public List<String> autoCompleteOwner(String query) {

		List<String> empNames = new ArrayList<String>();
		List<Employee> allEmp = empService.findAll();

		for (Employee emp : allEmp) {
			if (emp.getFirstname().contains(query) || emp.getEmployeeId().contains(query)
					|| emp.getLastname().contains(query)) {
				empNames.add(emp.getEmployeeId() + "-" + emp.getFirstname());
				Employee e = empService.findByUsername(emp.getEmployeeId());
				getAllemployee.add(e);
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

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public String getSelectedCompany() {
		return selectedCompany;
	}

	public void setSelectedCompany(String selectedCompany) {
		this.selectedCompany = selectedCompany;
	}

	public String getSelectedJob() {
		return selectedJob;
	}

	public void setSelectedJob(String selectedJob) {
		this.selectedJob = selectedJob;
	}

}
