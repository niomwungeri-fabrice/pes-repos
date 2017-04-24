package rw.itcg.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author NIYOMWUNGERI
 * Apr 24, 2017, 4:10:44 PM
 */
@Entity
public class Company extends GenericDomain{
	
	private static final long serialVersionUID = 1L;
	
	@Column(unique=true)
	private String companyId;
	private String companyName;
	
	@OneToMany(mappedBy="company")
	private List<Job> jobList;
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<Job> getJobList() {
		return jobList;
	}
	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}
	
	
}	
