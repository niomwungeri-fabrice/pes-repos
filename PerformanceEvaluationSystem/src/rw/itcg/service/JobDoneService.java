package rw.itcg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.itcg.dao.TaskDoneDao;
import rw.itcg.domain.TaskDone;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 1:49:48 PM
 */
@Service
public class JobDoneService extends TransactionAware {
	
	@Autowired
	private TaskDoneDao jDao;

	public void jobCompleted(TaskDone jobCompleted) {
		try {
			jDao.save(jobCompleted);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
