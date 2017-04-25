package rw.itcg.service;

import java.util.List;
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
	
	public Task findByUsername(String id) {
		return taskDao.findById(id);
	}

	public void createEmploye(Task task) {
		taskDao.save(task);

	}

	public List<Task> findAll() {
		return taskDao.findAll();
	}

	public void deleteEmployee(Task task) {
		taskDao.delete(task);
	}

	public void updateEmployee(Task task) {
		taskDao.update(task);
	}
	
	
}
