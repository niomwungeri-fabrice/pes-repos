package rw.itcg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.itcg.dao.TaskDao;
import rw.itcg.domain.Task;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 1:35:15 PM
 */
@Service
public class TaskService extends TransactionAware {

	@Autowired
	private TaskDao taskDao;

	public void createTask(Task task) {
		try {
			taskDao.save(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
