package gr.hua.dit.spr_hib.controller;

import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String getMenu() {
		 Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		 Set<String> roles = loggedInUser.getAuthorities().stream().map(r -> r.getAuthority()).collect(Collectors.toSet());
		 if(roles.contains("ROLE_SECRETARIAT")) { //different menu by user's role
			 return "secretMenu";
		 }
		 if(roles.contains("ROLE_STUDENT")) {
			 return "studentMenu";
		 }
			 return "";
	}
	

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login";//redirect at login page
	}
}
