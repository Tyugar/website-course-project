package project.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import project.Model.Entity.Opinion;
import project.Model.Entity.Whisky;
import project.Model.Repository.OpinionRepo;
import project.Model.Repository.WhiskyRepo;



@Controller
public class WhiskyController {
	
	@Autowired
	private WhiskyRepo whiskyRepo;
	
	Whisky whisky = new Whisky();
	
	@GetMapping("/whisky/{id}")
	public String ShowWhisky(@PathVariable (value = "id") long id, Model model) {
	whisky = whiskyRepo.getOne(id);
	model.addAttribute("whisky",whisky);
	model.addAttribute("newOpinion",new Opinion());
	return "whisky";
	
	}
	
	
	@PostMapping("/add-Opinion")
	public String addOpinion(@ModelAttribute Opinion opinion) {
		
		Date date = new Date();
		opinion.setCreatedAt(date);
		opinion.setWhisky(whisky);
		whisky.getOpinions().add(opinion);
		whiskyRepo.save(whisky);	
	
		return "redirect:/whisky/" + whisky.getId().toString();
	}
}