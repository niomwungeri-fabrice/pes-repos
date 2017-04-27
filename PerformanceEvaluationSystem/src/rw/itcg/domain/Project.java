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
public class Project extends GenericDomain{
	
	private static final long serialVersionUID = 1L;
	
	@Column(unique=true)
	private String projectId;
	private String projectName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="company_Id")
	private Company company;
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	
	



	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}
