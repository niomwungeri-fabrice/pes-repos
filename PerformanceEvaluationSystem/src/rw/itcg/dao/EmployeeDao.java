package rw.itcg.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import rw.itcg.domain.Employee;
import rw.itcg.genericDao.GenericDaoImpl;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 9:41:20 AM
 */
@Repository
public class EmployeeDao extends GenericDaoImpl<Employee> {
	public Employee findById(String empId) {
		Query query = sessionfactory().createQuery("select u from Employee u where u.employeeId = :employeeId");
		query.setParameter("employeeId", empId);
		return (Employee) query.uniqueResult();
	}
}
