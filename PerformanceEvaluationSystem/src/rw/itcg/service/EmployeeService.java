package rw.itcg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.itcg.dao.EmployeeDao;
import rw.itcg.domain.Employee;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 9:45:36 AM
 */
@Service
public class EmployeeService extends TransactionAware {

	@Autowired
	private EmployeeDao empDao;

	public void createEmploye(Employee employee) {
		empDao.save(employee);
		
	}

	public List<Employee> findAll() {
		try {
			return empDao.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
