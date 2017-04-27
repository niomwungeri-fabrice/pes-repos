package rw.itcg.test;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rw.itcg.domain.Employee;
import rw.itcg.service.EmployeeService;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 9:14:21 AM
 */
public class TestMyApp {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:rw/itcg/config/app-context.xml");
			EmployeeService empService = ctx.getBean(EmployeeService.class);
			Employee emp = new Employee();
			emp.setEmployeeId("EMP0001");
			emp.setFirstname("NIYOMWUNGERI");
			emp.setLastname("Fabrice");
			emp.setPhoneNumber("+250783741086");
			emp.setState(false);
			empService.createEmploye(emp);

			HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance()
					.getExternalContext().getRequest();
			String ip = httpServletRequest.getRemoteAddr();

			System.out.println("success" + ip);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error:" + e.getMessage());
		}

	}

}
