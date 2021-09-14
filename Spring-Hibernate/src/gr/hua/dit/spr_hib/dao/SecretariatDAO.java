package gr.hua.dit.spr_hib.dao;


import gr.hua.dit.spr_hib.entity.*;

public interface SecretariatDAO {

	public String insertUser(Users user);
	
	public void insertStudent(Student student,int std);
	
	public void deleteUser(String username);
	
	public void activateUser(String username);
	
	public void deleteApplication(int id);
}
