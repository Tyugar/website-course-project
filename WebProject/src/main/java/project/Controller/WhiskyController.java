package project.Controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.Model.Entity.Opinion;
import project.Model.Entity.User;
import project.Model.Entity.Whisky;
import project.Model.Repository.OpinionRepo;
import project.Model.Repository.WhiskyRepo;
import project.Service.OpinionService;
import project.Service.UserService;
import project.Service.VoteService;



@Controller
public class WhiskyController {
	
	@Autowired
	private WhiskyRepo whiskyRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OpinionService opinionService;
	
	@Autowired
	private VoteService voteService;
	
	Whisky whisky = new Whisky();
	
	@GetMapping("/whisky/{id}")
	public String ShowWhisky(@PathVariable (value = "id") long id, Model model, Principal principal) {
		System.out.println(id);
	whisky = whiskyRepo.getOne(id);
	Boolean haveAlreadyReviewed = opinionService.haveAlreadyReviewed(id, userService.findByUsername(principal.getName()).getId());
	model.addAttribute("haveAlreadyReviewed",haveAlreadyReviewed);
	model.addAttribute("user",principal);
	model.addAttribute("whisky",whisky);
	model.addAttribute("newOpinion",new Opinion());
	

	
	return "whisky";
	
	}
	
	
	@PostMapping("/add-Opinion")
	public String addOpinion(@ModelAttribute Opinion opinion, Principal principal ) {
		

		User currentUser = userService.findByUsername(principal.getName());
		Date date = new Date();
		opinion.setUser(currentUser);
		opinion.setCreatedAt(date);
		opinion.setWhisky(whisky);
		whisky.getOpinions().add(opinion);
		whiskyRepo.save(whisky);	
	
		return "redirect:/whisky/" + whisky.getId().toString();
	}
	
	
	@RequestMapping(value = "/voteLike")
	@ResponseBody
	public String voteLike(@RequestParam Long opinionId,Principal principal) {
		long result = voteService.voteLike(opinionId, principal);
	
		if(result == -2) return "Glosujesz sam na siebie";
		else if(result == 1) return "Glosujesz na tak";
		else return "error sth went wrong";	
	}
	
	
}