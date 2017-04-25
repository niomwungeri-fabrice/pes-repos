package rw.itcg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.itcg.dao.JobDao;
import rw.itcg.domain.Job;

/**
 * @author NIYOMWUNGERI Apr 25, 2017, 9:11:15 PM
 */
@Service
public class JobService extends TransactionAware {

	@Autowired
	private JobDao jDao;

	public void createJob(Job job) {
		jDao.save(job);
	}

	public void deleteJob(Job job) {
		jDao.delete(job);
	}

	public void updateJob(Job job) {
		jDao.update(job);
	}

	public Job findById(String jobId) {
		return jDao.findById(jobId);
	}

	public List<Job> findByIdList(String jobId) {
		return jDao.findByIdList(jobId);
	}
}
