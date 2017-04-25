package rw.itcg.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import rw.itcg.domain.TaskDone;
import rw.itcg.genericDao.GenericDaoImpl;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 1:54:22 PM
 */
@Repository
public class TaskDoneDao extends GenericDaoImpl<TaskDone> {

	public TaskDone findById(long taskDoneId) {
		Query query = sessionfactory().createQuery("select t from TaskDone t where t.jobId = :jobId");
		query.setParameter("jobId", taskDoneId);
		return (TaskDone) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<TaskDone> findByIdList(long taskDoneId) {
		Query query = sessionfactory().createQuery("select t from TaskDone t where t.jobId = :jobId");
		query.setParameter("jobId", taskDoneId);
		return query.list();
	}
}
