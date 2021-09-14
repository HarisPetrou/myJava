package gr.hua.dit.spr_hib.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import gr.hua.dit.spr_hib.dao.ProfessorDAO;
import gr.hua.dit.spr_hib.entity.Application;
import gr.hua.dit.spr_hib.entity.Subject;

@RestController
@RequestMapping("/api")
public class ProfessorRestController {
	
	@Autowired
    private ProfessorDAO ProfessorDAO;
	
	
	@GetMapping("/getapplications") //returns student's applications
	@ResponseBody
	public List<Application> showApplications() {
		List<Application> applications = ProfessorDAO.getApplications();
		return applications;
        
    }
	@GetMapping("/getsubjects") //returns professor's subjects
	@ResponseBody
	public List<Subject> test2() {
		List<Subject> subjects = ProfessorDAO.getSubjects();
    	return subjects;
           
    }
	
	@PostMapping("/addsubject") //add a new subject in database
	@ResponseBody
	public String addSubject(@RequestBody String test) {
		ProfessorDAO.insertSubject(test);
		String word = "good";
		return word;
	}
	
	
	@PostMapping("/acceptapplication")//when a professor accepts a student's application
	@ResponseBody
		public String acceptApplication(@RequestBody String id) {
			
			ProfessorDAO.acceptApplication(id);
			String word = "changed";
			return word;
		}
	
	@PostMapping("/rejectapplication")//when a professor rejects a student's application
	@ResponseBody
		public String deleteApplication(@RequestBody String id) {
					
			ProfessorDAO.deleteApplication(id);
			String word = "deleted";
			return word;
		}
	
	@PostMapping("/login")//controller about login 
	@ResponseBody
		public String test() {
			String word = "hello!";
			return word;
		}
	
	
}
