package rw.itcg.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author NIYOMWUNGERI
 * Apr 24, 2017, 3:38:05 PM
 */
@Entity
public class Job extends GenericDomain{
	
	private static final long serialVersionUID = 1L;
	
	@Column(unique=true)
	private String jobId;
	private String jobName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="company_Id")
	private Company company;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}
