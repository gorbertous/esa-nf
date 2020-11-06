package eu.europa.ec.estat.esa.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

//import java.util.Arrays;

//import javax.validation.Valid;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;

//import eu.europa.ec.estat.esa.model.User;
//import eu.europa.ec.estat.esa.repository.UserRepository;
//import eu.europa.ec.estat.esa.web.UserRegistrationDto;

@Controller
public class MainController {

//	@Autowired
//	UserRepository userR;

	@GetMapping(value = { "/", "/index" })
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		if (isAuthenticated()) {
	        return "redirect:chapters";
	    }
		return "login";
	}
	
	private boolean isAuthenticated() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication == null || AnonymousAuthenticationToken.class.
	      isAssignableFrom(authentication.getClass())) {
	        return false;
	    }
	    return authentication.isAuthenticated();
	}

//	@GetMapping
//	public String currentUser(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result,
//			Model model) {
//
//		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//		String email = loggedInUser.getName();
//
//		User user = userR.findByEmail(email);
//		String firstname = user.getFirstName();
//		model.addAttribute("firstName", firstname);
//		model.addAttribute("emailAddress", email);
//
//		return "fragments/left-adm"; // this is the name of my template
//	}
	
//	@ModelAttribute("loggedinuser")
//    public User globalUserObject(Model model) {
//        // Add all null check and authentication check before using. Because this is global 
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("loggedinuser", authentication.getName());
//        model.addAttribute("roles", authentication.getAuthorities());
//        // Create User pojo class
//        User user = new User(authentication.getName(), Arrays.asList(authentication.getAuthorities()));
//        return user;
//    }
	

//	@GetMapping("/user")
//	public String userIndex() {
//		return "user/index";
//	}

	@GetMapping("/403")
	public String error403() {
		return "403";
	}
}
