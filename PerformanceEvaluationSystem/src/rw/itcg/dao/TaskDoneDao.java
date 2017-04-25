package rw.itcg.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import rw.itcg.domain.Employee;
import rw.itcg.domain.TaskDone;
import rw.itcg.genericDao.GenericDaoImpl;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 1:54:22 PM
 */
@Repository
public class TaskDoneDao extends GenericDaoImpl<TaskDone> {

	public Employee findById(String jobId) {
		Query query = sessionfactory().createQuery("select t from TaskDone t where t.jobId = :jobId");
		query.setParameter("jobId", jobId);
		return (Employee) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findByIdList(String jobId) {
		Query query = sessionfactory().createQuery("select t from TaskDone t where t.jobId = :jobId");
		query.setParameter("jobId", jobId);
		return query.list();
	}
}
