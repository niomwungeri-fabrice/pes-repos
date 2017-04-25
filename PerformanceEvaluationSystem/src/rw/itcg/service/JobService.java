package rw.itcg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.itcg.dao.JobDao;

/**
 * @author NIYOMWUNGERI
 * Apr 25, 2017, 9:11:15 PM
 */
@Service
public class JobService extends TransactionAware {
	
	@Autowired
	private JobDao jDao;
}
