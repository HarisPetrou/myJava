package gr.hua.dit.spr_hib.dao;

import java.util.List;

import gr.hua.dit.spr_hib.entity.*;

public interface StudentDAO {

	public List<Student> getMyData();
	
	public List<Subject> getSubjects();
	
	public List<Users> getMyUserData();
	
	public void insertApplication(Application application);
}
