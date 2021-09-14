package gr.hua.dit.spr_hib.dao;

import java.util.List;

import gr.hua.dit.spr_hib.entity.Application;
import gr.hua.dit.spr_hib.entity.Subject;
import gr.hua.dit.spr_hib.entity.Users;

public interface ProfessorDAO {

	public List<Application> getApplications();
	
	public List<Subject> getSubjects();
	
	public void insertSubject(String subject);
	
	public void acceptApplication(String id);
	
	public void deleteApplication(String id);
	
}
