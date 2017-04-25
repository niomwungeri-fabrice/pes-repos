package rw.itcg.dao;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rw.itcg.domain.Task;
import rw.itcg.genericDao.GenericDaoImpl;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 1:31:18 PM
 */
@Repository
public class TaskDao extends GenericDaoImpl<Task> {
	public Task findById(String taskId) {
		Query query = sessionfactory().createQuery("select t from Task t where t.taskId = :taskId");
		query.setParameter("taskId", taskId);
		return (Task) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Task> findByIdList(String taskId) {
		Query query = sessionfactory().createQuery("select t from Task t where t.taskId = :taskId");
		query.setParameter("taskId", taskId);
		return query.list();
	}
}
