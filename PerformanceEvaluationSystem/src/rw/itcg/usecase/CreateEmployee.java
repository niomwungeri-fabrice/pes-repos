package rw.itcg.usecase;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
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

	public void delete(Employee emp) {
		try {
			empService.deleteEmployee(emp);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Employee "+emp.getFirstname()+" Deleted"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Error:" + e.getMessage()));
		}
	}

	// create new employee
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

	// cancel on update
	public void onCancel(RowEditEvent event) {
		try {
			Employee u = (Employee) event.getObject();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancelled" + u.getFirstname(), null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error>>" + e.getMessage(), null));
		}
	}

	// update employee
	public void onEdit(RowEditEvent event) {
		try {
			employee = (Employee) event.getObject();
			empService.updateEmployee(employee);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "User Updated", null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error>>" + e.getMessage(), null));
		}
	}

	// activate employee
	public void activateEmployee(Employee emp) {
		try {
			this.employee = empService.findByUsername(emp.getEmployeeId());
			if (employee.isState()) {
				employee.setState(false);
				empService.updateEmployee(employee);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Employee Suspended", null));
			} else {
				employee.setState(true);
				empService.updateEmployee(employee);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee Activated", null));
			}
		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error : ", e.getMessage()));
		}

	}

	// find all employee
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
