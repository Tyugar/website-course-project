package project.Controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.Model.Entity.Whisky;
import project.Model.Repository.WhiskyRepo;

@Controller
public class IndexController {

	@Autowired
	private WhiskyRepo whiskyRepo;
	
	@GetMapping("/")	
	public String ShowIndex(Model model, Principal principal) {
			List<Whisky> whiskys = whiskyRepo.findAll();
		 model.addAttribute("user",principal);
		 model.addAttribute("whiskys",whiskys);
		 model.addAttribute("newWhisky",new Whisky());
		return "index";
	}
	
	@PostMapping("/add-Whisky")
	public String addWhisky(@ModelAttribute Whisky whisky) {
		whiskyRepo.save(whisky);
		return "redirect:/";
	}
	
	
	@GetMapping("/search")
	public String search (@RequestParam(value="search")String search, Model model) {
		List<Whisky> whiskys = whiskyRepo.findByNameContainingIgnoreCase(search);
		model.addAttribute("whiskys",whiskys);
		return "search";
	}
	
	
			
}
