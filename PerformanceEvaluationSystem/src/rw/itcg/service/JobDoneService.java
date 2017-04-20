package rw.itcg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.itcg.dao.JobDoneDao;
import rw.itcg.domain.TaskDone;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 1:49:48 PM
 */
@Service
public class JobDoneService extends TransactionAware {
	
	@Autowired
	private JobDoneDao jDao;

	public void jobCompleted(TaskDone jobCompleted) {
		try {
			jDao.save(jobCompleted);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
