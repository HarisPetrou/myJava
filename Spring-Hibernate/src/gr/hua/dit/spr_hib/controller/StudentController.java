package gr.hua.dit.spr_hib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gr.hua.dit.spr_hib.dao.*;
import gr.hua.dit.spr_hib.entity.*;


@Controller
@RequestMapping("/student")
public class StudentController {
        
		@Autowired
	    private StudentDAO StudentDAO;
		
        @RequestMapping("/mydata")//returns student's data with a jsp page
        public String sendStudents(Model model) {
        	List<Student> mydata = StudentDAO.getMyData();
        	List<Users> myuserdata = StudentDAO.getMyUserData();
        	
        	model.addAttribute("mydata",mydata);
        	model.addAttribute("myuserdata", myuserdata);
        	
        	return "mydata";
        }
        
        @RequestMapping("/showsubjects")
        public String checkSubjects(Model model) { //returns all subjects (from all professors)
        	List<Subject> subjects = StudentDAO.getSubjects();
        	model.addAttribute("subjects",subjects);
        	
        	return "list-of-subjects";
        }
        
        @RequestMapping(value="/application",method=RequestMethod.GET)//creates a new application
        public ModelAndView showApplicationForm() {
    		return new ModelAndView("applicationAddHome","application",new Application());
    	}
        
        @RequestMapping(value = "/addApplication", method = RequestMethod.POST) 
        public String submitAdd(@Validated @ModelAttribute("application")Application application, 
          BindingResult result, ModelMap model) {
          application.setState("Under evaluation");
    	  StudentDAO.insertApplication(application);
            return "success";
        }

}