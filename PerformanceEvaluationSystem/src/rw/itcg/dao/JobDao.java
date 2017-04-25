package rw.itcg.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import rw.itcg.domain.Job;
import rw.itcg.genericDao.GenericDaoImpl;

/**
 * @author NIYOMWUNGERI Apr 25, 2017, 9:12:30 PM
 */
@Repository
public class JobDao extends GenericDaoImpl<Job> {
	public Job findById(String jobId) {
		Query query = sessionfactory().createQuery("select j from Job j where j.jobId = :jobId");
		query.setParameter("jobId", jobId);
		return (Job) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Job> findByIdList(String jobId) {
		Query query = sessionfactory().createQuery("select j from Job j where j.jobId = :jobId");
		query.setParameter("jobId", jobId);
		return query.list();
	}
}
