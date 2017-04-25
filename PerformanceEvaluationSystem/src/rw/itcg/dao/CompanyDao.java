package rw.itcg.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import rw.itcg.domain.Company;
import rw.itcg.domain.Employee;
import rw.itcg.genericDao.GenericDaoImpl;

/**
 * @author NIYOMWUNGERI
 * Apr 25, 2017, 9:12:45 PM
 */
@Repository
public class CompanyDao extends GenericDaoImpl<Company>{
	
	public Company findById(String compId) {
		Query query = sessionfactory().createQuery("select c from Company c where c.companyId = :companyId");
		query.setParameter("companyId", compId);
		return (Company) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> findByIdList(String compId) {
		Query query = sessionfactory().createQuery("select c from Company c where c.companyId = :companyId");
		query.setParameter("companyId", compId);
		return query.list();
	}
	
}
