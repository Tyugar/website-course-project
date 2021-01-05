package project.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import project.Model.Entity.User;
import project.Model.Repository.UserRepo;
import project.Model.Repository.WhiskyRepo;
import project.Service.SecurityService;
import project.Service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("newUser",new User());
		
	    if (securityService.isAuthenticated()) {
            return "redirect:/";
	    }
	    return "login";
	}
	
	
	@PostMapping("/register")
	private String register(@ModelAttribute User user) {
		String password = user.getPassword();
		userService.save(user);
		securityService.autoLogin(user.getUsername(), password);
	    return "redirect:/";
	}
	
	
	
}
