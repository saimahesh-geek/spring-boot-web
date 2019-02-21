package sm.springboot.mingleoccean.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sm.springboot.mingleoccean.web.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showLogin(ModelMap model) {
		model.put("name", getLoggedInUserName());	
		return "redirect:/mingle-ocean";
	}
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String handleLogin(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean isValidUser = loginService.validateUser(name, password);
		
		if (!isValidUser) {		
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
		model.put("name", name);
		model.put("password", password);
		
		return "redirect:/mingle-ocean";
	}
}
