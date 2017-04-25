package rw.itcg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.itcg.dao.TaskDoneDao;
import rw.itcg.domain.TaskDone;

/**
 * @author NIYOMWUNGERI Apr 20, 2017, 1:49:48 PM
 */
@Service
public class TaskDoneService extends TransactionAware {
	
	@Autowired
	private TaskDoneDao taskDoneDao;

	public void recordTaskDone(TaskDone tDone) {
		taskDoneDao.save(tDone);
	}

	public void deleteTaskDone(TaskDone tDone) {
		taskDoneDao.delete(tDone);
	}

	public void updateTaskDone(TaskDone tDone) {
		taskDoneDao.update(tDone);
	}

	public TaskDone findById(long tDoneId) {
		return taskDoneDao.findById(tDoneId);
	}

	public List<TaskDone> findAll() {
		return taskDoneDao.findAll();
	}

	public List<TaskDone> findByIdList(long tDoneId) {
		return taskDoneDao.findByIdList(tDoneId);
	}
	
}
