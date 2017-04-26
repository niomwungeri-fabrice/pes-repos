package rw.itcg.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rw.itcg.domain.Company;
import rw.itcg.service.CompanyService;

/**
 * @author NIYOMWUNGERI Apr 25, 2017, 9:10:09 PM
 */
@Component
@ManagedBean
public class SettingsBean {

	@Autowired
	private CompanyService compService;
	private Company company = new Company();

	public List<Company> getAllcompany() {
		return compService.findAll();
	}

	public void createCompany() {
		try {
			compService.createCompany(company);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Company Created"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Error:" + e.getMessage()));
		}
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
