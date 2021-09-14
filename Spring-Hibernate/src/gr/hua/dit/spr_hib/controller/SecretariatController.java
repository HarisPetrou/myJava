package gr.hua.dit.spr_hib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gr.hua.dit.spr_hib.dao.*;
import gr.hua.dit.spr_hib.entity.Application;
import gr.hua.dit.spr_hib.entity.Student;
import gr.hua.dit.spr_hib.entity.Users;

@Controller
@RequestMapping("/secretariat")
public class SecretariatController {
	
	@Autowired
    private SecretariatDAO SecretariatDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public int std;
	
	@RequestMapping(value="/add",method=RequestMethod.GET) //creates a new user
    public ModelAndView showAddForm() {
		return new ModelAndView("userAddHome","user",new Users());
	}
	
	  @RequestMapping(value = "/addUser", method = RequestMethod.POST) 
	    public ModelAndView submitAdd(@Validated @ModelAttribute("user")Users user, 
	      BindingResult result, ModelMap model) {
	       
		  user.setPassword(passwordEncoder.encode(user.getPassword()));
		  String word = SecretariatDAO.insertUser(user);
		  
		    model.addAttribute("id", user.getId());
	        model.addAttribute("fullName", user.getFullName());
	        model.addAttribute("username", user.getUsername());
	        model.addAttribute("password", user.getPassword());
	        model.addAttribute("email", user.getEmail());
	        model.addAttribute("studentId", user.getStudentId());
	        model.addAttribute("professorId", user.getProfessorId());
	        model.addAttribute("enabled", user.getEnabled());
	        std = user.getStudentId();
	        
	        return new ModelAndView(word,"student",new Student()); 
	    }
	  
	  @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	    public ModelAndView submit(@Validated @ModelAttribute("student")Student student,BindingResult result, ModelMap model) {
	       
		    model.addAttribute("id", std);
		    model.addAttribute("studentId",student.getStudentId());
	        model.addAttribute("semester", student.getSemester());
	        model.addAttribute("average", student.getAverage());
	        model.addAttribute("studiesLevel", student.getStudiesLevel());
	        model.addAttribute("owedCoursesNumber", student.getOwedCoursesNumber());
	        model.addAttribute("owedCourses", student.getOwedCourses());
	       
		  SecretariatDAO.insertStudent(student,std);
		  ModelAndView  succ = new ModelAndView("success");
		  return succ;
	    }
	  
	  @RequestMapping(value="/delete",method=RequestMethod.GET) //deletes a user
	    public ModelAndView showDeleteForm() {
			return new ModelAndView("userDeleteHome","user",new Users());
		}
	  
	  @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	    public ModelAndView submitDelete(@Validated @ModelAttribute("user")Users user, 
	      BindingResult result, ModelMap model) {
	      
		  SecretariatDAO.deleteUser(user.getUsername());
		  
		  ModelAndView  succ = new ModelAndView("success");
		  return succ;
	    }
	  
	  @RequestMapping(value="/activate",method=RequestMethod.GET) //activates a student (professor is activated by default)
	    public ModelAndView showActivateForm() {
			return new ModelAndView("userActivateHome","user",new Users());
		}
	  @RequestMapping(value = "/activateUser", method = RequestMethod.POST)
	    public ModelAndView submitActivate(@Validated @ModelAttribute("user")Users user, 
	      BindingResult result, ModelMap model) {
	      
		  SecretariatDAO.activateUser(user.getUsername());
		  
		  ModelAndView  succ = new ModelAndView("success");
		  return succ;
	    }
	  
	  @RequestMapping(value="/application",method=RequestMethod.GET) //deletes a student's application
	    public ModelAndView showApplicationDeleteeForm() {
			return new ModelAndView("applicationDeleteForm","application",new Application());
		}
	  
	  @RequestMapping(value = "/deleteApplication", method = RequestMethod.POST)
	    public ModelAndView submitDelete(@Validated @ModelAttribute("application")Application application, 
	      BindingResult result, ModelMap model) {
	      
		  SecretariatDAO.deleteApplication(application.getId());
		  
		  ModelAndView  succ = new ModelAndView("success");
		  return succ;
	    }
	  
}
