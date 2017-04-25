package rw.itcg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.itcg.dao.CompanyDao;
import rw.itcg.domain.Company;

/**
 * @author NIYOMWUNGERI Apr 25, 2017, 9:10:58 PM
 */
@Service
public class CompanyService extends TransactionAware {
	@Autowired
	private CompanyDao companyDao;

	public void createCompany(Company comp) {
		companyDao.save(comp);
	}

	public List<Company> findAll() {
		return companyDao.findAll();
	}
	
	

}
