package rw.itcg.test;

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
			emp.setFirstname("fab");
			emp.setLastname("fab");
			emp.setPhoneNumber("2500");
			emp.setState(false);
			empService.createEmploye(emp);
			System.out.println("success");

		} catch (Exception e) {
			System.out.println("error:"+e.getMessage());
		}

	}

}
