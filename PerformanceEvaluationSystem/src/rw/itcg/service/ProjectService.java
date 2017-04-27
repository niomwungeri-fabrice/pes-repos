package rw.itcg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.itcg.dao.ProjectDao;
import rw.itcg.domain.Project;

/**
 * @author NIYOMWUNGERI Apr 25, 2017, 9:11:15 PM
 */
@Service
public class ProjectService extends TransactionAware {

	@Autowired
	private ProjectDao pDao;

	public void createProject(Project job) {
		pDao.save(job);
	}

	public void deleteProject(Project job) {
		pDao.delete(job);
	}

	public void updateProject(Project job) {
		pDao.update(job);
	}

	public Project findById(String jobId) {
		return pDao.findById(jobId);
	}

	public List<Project> findByIdList(String jobId) {
		return pDao.findByIdList(jobId);
	}

	public List<Project> findAll() {
		return pDao.findAll();
	}
}
