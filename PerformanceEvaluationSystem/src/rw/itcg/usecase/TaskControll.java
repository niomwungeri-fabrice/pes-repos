package rw.itcg.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rw.itcg.domain.Employee;
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
	private double itemsDone;

	public TaskControll() {
		getAllemployee = new ArrayList<Employee>();
	}

	public List<String> autoCompleteOwner(String query) {

		List<String> empNames = new ArrayList<String>();
		List<Employee> allEmp = empService.findAll();

		for (Employee emp : allEmp) {
			if (emp.getFirstname().startsWith(query) || emp.getEmployeeId().startsWith(query)
					|| emp.getLastname().startsWith(query) || emp.getPhoneNumber().startsWith(query)) {
				empNames.add(emp.getFirstname() + "  " + emp.getLastname());
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

	public double getItemsDone() {
		return itemsDone;
	}

	public void setItemsDone(double itemsDone) {
		this.itemsDone = itemsDone;
	}

}
