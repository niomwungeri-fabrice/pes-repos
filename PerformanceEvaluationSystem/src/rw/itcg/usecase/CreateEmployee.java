package rw.itcg.usecase;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rw.itcg.domain.Employee;
import rw.itcg.service.EmployeeService;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 3:27:19 PM
 */
@Component
@ManagedBean
public class CreateEmployee {

	@Autowired
	private EmployeeService empService;
	private Employee employee = new Employee();

	public void createEmploye() {
		try {
			empService.createEmploye(employee);
			employee = new Employee();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Employee Registered Successfully"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Error:" + e.getMessage()));
		}

	}

	public List<Employee> getAllemployee() {
		return empService.findAll();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
