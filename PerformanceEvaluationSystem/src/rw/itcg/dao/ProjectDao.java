package rw.itcg.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import rw.itcg.domain.Project;
import rw.itcg.genericDao.GenericDaoImpl;

/**
 * @author NIYOMWUNGERI Apr 25, 2017, 9:12:30 PM
 */
@Repository
public class ProjectDao extends GenericDaoImpl<Project> {
	public Project findById(String pId) {
		Query query = sessionfactory().createQuery("select p from Project p where p.projectId = :projectId");
		query.setParameter("projectId", pId);
		return (Project) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Project> findByIdList(String pId) {
		Query query = sessionfactory().createQuery("select p from Project p where p.projectId = :projectId");
		query.setParameter("projectId", pId);
		return query.list();
	}
}
