package gr.hua.dit.spr_hib.dao;

import java.sql.Statement;
import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;




import gr.hua.dit.spr_hib.entity.*;

@Repository
public class SecretariatDAOImpl implements SecretariatDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public String insertUser(Users user) { //inserts a new user
		
		Session currentSession = sessionFactory.getCurrentSession();

		Authority newauthority = new Authority();
		newauthority.setUsername(user.getUsername());
		

		if(user.getStudentId()==0) { //activates a user only if he has professor role				
			newauthority.setAuthority("ROLE_PROFESSOR");			
			user.setEnabled("1");
			currentSession.save(user);
			currentSession.save(newauthority);
			return "userAddView";
		}else {
			newauthority.setAuthority("ROLE_STUDENT");
			user.setEnabled("0");
			currentSession.save(user);
			currentSession.save(newauthority);
			return "studentForm";
		}
     }
	
	@Override
	@Transactional
	public void insertStudent(Student student,int std) { //inserts a new student
		Session currentSession = sessionFactory.getCurrentSession();
		student.setStudentId(std);
		
		currentSession.save(student);
		
	}
	
	@Override
	@Transactional
	public void deleteUser(String username) { //deletes a user
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Users> query = currentSession.createQuery("from Users where username='"+username+"'", Users.class);
	    Query q;
	    List<Users> myuserdata = query.getResultList();
	    int theid = myuserdata.get(0).getStudentId();
		q = currentSession.createQuery("delete Authority where username='"+username+"'");
		q.executeUpdate();
		q = currentSession.createQuery("delete Users where username='"+username+"'");
		q.executeUpdate();
		if(theid!=0) {
			q = currentSession.createQuery("delete Student where student_id="+theid);
			q.executeUpdate();
		}
		
	}
	
	@Override
	@Transactional
	public void activateUser(String username) { //activates a student
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Users> query = currentSession.createQuery("from Users where username='"+username+"'", Users.class);
	    List<Users> myuserdata = query.getResultList();
	    Users user = myuserdata.get(0);
	    if(user.getEnabled().equals("1")) {
	    }else {	    	  
	        int studentid = user.getStudentId();
	        Query<Student> q = currentSession.createQuery("from Student where student_id="+studentid, Student.class);
	        List<Student> studentsdata = q.getResultList();
	        Student currentstudent = studentsdata.get(0);
	        if(currentstudent.getStudiesLevel().equals("Undergraduate")) {
	        	if(currentstudent.getSemester()>=7 && currentstudent.getOwedCoursesNumber()<4) {
	        		user.setEnabled("1");
	        		currentSession.save(user);		
	        	}
	        }else {
	        	if(currentstudent.getSemester()>=3 && currentstudent.getOwedCoursesNumber()<2) {
	        		user.setEnabled("1");
	        		currentSession.save(user);
	        	}
	        }	    	
	    }
		
	}
	
	@Override
	@Transactional
	public void deleteApplication(int appid) { //deletes an application
		Session currentSession = sessionFactory.getCurrentSession();
		Query q = currentSession.createQuery("delete Application where id="+appid);
		q.executeUpdate();
		
	}

}
