package gr.hua.dit.spr_hib.dao;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import gr.hua.dit.spr_hib.entity.Application;
import gr.hua.dit.spr_hib.entity.Student;
import gr.hua.dit.spr_hib.entity.Subject;
import gr.hua.dit.spr_hib.entity.Users;


@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Student> getMyData() {//returns student's data
	
        Session currentSession = sessionFactory.getCurrentSession();
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();;
        Query<Users> query = currentSession.createQuery("from Users where username='"+username+"'", Users.class);
        List<Users> myuserdata = query.getResultList();
        Users user = myuserdata.get(0);
        int currentid = user.getStudentId();
        Query<Student> q = currentSession.createQuery("from Student where student_id="+currentid, Student.class);
 
        List<Student> mydata = q.getResultList();
 
        return mydata;
	}
	
	@Override
	@Transactional
	public List<Users> getMyUserData() {//returns user's data
	
        Session currentSession = sessionFactory.getCurrentSession();
        
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();;
     
        Query<Users> query = currentSession.createQuery("from Users where username='"+username+"'", Users.class);
        
        List<Users> myuserdata = query.getResultList();

        return myuserdata;
	}

	@Override
	@Transactional
	public List<Subject> getSubjects() {//returns all subjects
		
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Subject> query = currentSession.createQuery("from Subject", Subject.class);

        List<Subject> subjects = query.getResultList();

        return subjects;
	}
	
	@Override
	@Transactional
	public void insertApplication(Application application) {//inserts a new application in database
		Session currentSession = sessionFactory.getCurrentSession();
		application.setApplicationDate(new Date(System.currentTimeMillis()));
		currentSession.persist(application);
	}
}
