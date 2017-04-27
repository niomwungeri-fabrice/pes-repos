package rw.itcg.usecase;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rw.itcg.domain.Company;
import rw.itcg.domain.Project;
import rw.itcg.service.CompanyService;
import rw.itcg.service.ProjectService;

/**
 * @author NIYOMWUNGERI Apr 25, 2017, 9:10:09 PM
 */
@Component
@ManagedBean
public class SettingsBean {

	private String projectName;
	@Autowired
	private CompanyService compService;

	@Autowired
	private ProjectService projectService;

	private Company company = new Company();
	private Project project = new Project();

	public List<Company> getAllcompany() {
		return compService.findAll();
	}

	public void addJob() {
		try {
			project.setProjectName(projectName);
			projectService.createProject(project);
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Project Added successfully", "Project Added successfully"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Error:" + e.getMessage()));
		}
	}

	public void createCompany() {
		try {
			compService.createCompany(company);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Company Created succussfully", "Company Created succussfully"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Error:" + e.getMessage()));
		}
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


}
