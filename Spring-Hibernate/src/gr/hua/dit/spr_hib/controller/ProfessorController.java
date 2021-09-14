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
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
    private ProfessorDAO ProfessorDAO;
	
	@RequestMapping("/showapplications")
    public String showApplications(Model model) {
		List<Application> applications = ProfessorDAO.getApplications();
    	
    	model.addAttribute("applications",applications);
    	
    	return "list-of-applications";
           
    }
	
	@RequestMapping("/showsubjects")
    public String checkSubjects(Model model) {
		
		List<Subject> subjects = ProfessorDAO.getSubjects();
    	
    	model.addAttribute("subjects",subjects);
    	
    	return "list-of-subjects";
           
    }
	
	
	
	@RequestMapping(value="/subject",method=RequestMethod.GET)
    public ModelAndView showSubjectForm() {
		return new ModelAndView("subjectAddHome","subject",new Subject());
	}
	
	@RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    public String submitAdd(@Validated @ModelAttribute("subject")Subject subject, 
      BindingResult result, ModelMap model) {
       
	  //System.out.println(user.toString());
	  ProfessorDAO.insertSubject(subject);
        return "";
    }
}
