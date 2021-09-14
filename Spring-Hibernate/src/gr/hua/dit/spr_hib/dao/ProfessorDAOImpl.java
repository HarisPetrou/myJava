package gr.hua.dit.spr_hib.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;



import gr.hua.dit.spr_hib.entity.*;
import net.sf.json.*;

@Repository
public class ProfessorDAOImpl implements ProfessorDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Application> getApplications() { //get applications for a specific professor
		 
        Session currentSession = sessionFactory.getCurrentSession();
        
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();;

        Query<Users> query = currentSession.createQuery("from Users where username='"+username+"'", Users.class);
        List<Users> myuserdata = query.getResultList();
        Users user = myuserdata.get(0);
        int currentid = user.getProfessorId();
       
        Query<Application> q = currentSession.createQuery("from Application where id_professor="+currentid, Application.class);
   
        List<Application> applications = q.getResultList();
                        
        return applications;
	}
	
	@Override
	@Transactional
	public List<Subject> getSubjects() { //get subjects of a specific professor
        Session currentSession = sessionFactory.getCurrentSession();
        
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();;
        
        Query<Users> query = currentSession.createQuery("from Users where username='"+username+"'", Users.class);
        List<Users> myuserdata = query.getResultList();
        Users user = myuserdata.get(0);
        int currentid = user.getProfessorId();
 
        Query<Subject> q = currentSession.createQuery("from Subject where supervisor_id="+currentid, Subject.class);
        
        List<Subject> subjects = q.getResultList();
                        
        return subjects;
	}
	
	@Override
	@Transactional
	public void insertSubject(String test) { //insert a new professor's subject
		
		Session currentSession = sessionFactory.getCurrentSession();
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();;
        
        Query<Users> query = currentSession.createQuery("from Users where username='"+username+"'", Users.class);
        List<Users> myuserdata = query.getResultList();
        Users user = myuserdata.get(0);
        int currentid = user.getProfessorId();
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(test);
			JSONObject texas = (JSONObject) obj;
			
			String title = (String) texas.get("title");
			String prerequisites = (String) texas.get("prerequisites");
			String studiesLevel = (String) texas.get("studiesLevel");
			String numberOfStudents = (String) texas.get("numberOfStudents");
			int result = Integer.parseInt(numberOfStudents);	
				
			Subject newsub = new Subject();
			newsub.setTitle(title);			
			newsub.setPrerequisites(prerequisites);
			newsub.setStudiesLevel(studiesLevel);			
	        	               
			newsub.setSupervisorId(currentid);
			newsub.setNumberOfStudents(result);

			currentSession.persist(newsub);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	@Transactional
	public void acceptApplication(String id) { //when a professor accepts a application
		
		Session currentSession = sessionFactory.getCurrentSession();
		 
		Query<Application> query = currentSession.createQuery("from Application where id='"+id+"'", Application.class);
		Application changedapp = new Application();
		changedapp.setId(query.getResultList().get(0).getId());
		changedapp.setThesisName(query.getResultList().get(0).getThesisName());
		changedapp.setApplicationDate(query.getResultList().get(0).getApplicationDate());
		changedapp.setIdProfessor(query.getResultList().get(0).getIdProfessor());
		changedapp.setIdStudent(query.getResultList().get(0).getIdStudent());
		changedapp.setState("Accepted");
		Query q = currentSession.createQuery("delete Application where id='"+id+"'");
		q.executeUpdate();
		currentSession.save(changedapp);
	}
	
	@Override
	@Transactional
	public void deleteApplication(String id) { //delete a application from database
		Session currentSession = sessionFactory.getCurrentSession();
		Query q = currentSession.createQuery("delete Application where id='"+id+"'");
		q.executeUpdate();		
	}
	
}
