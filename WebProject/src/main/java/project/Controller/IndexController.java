package project.Controller;

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

import project.Model.Entity.Whisky;
import project.Model.Repository.WhiskyRepo;

@Controller
public class IndexController {

	@Autowired
	private WhiskyRepo whiskyRepo;
	
	@GetMapping("/")	
	public String ShowIndex(Model model) {
			List<Whisky> whiskys = whiskyRepo.findAll();
			Whisky newWhisky = new Whisky();
		 model.addAttribute("name","Strzepan");
		 model.addAttribute("whiskys",whiskys);
		 model.addAttribute("newWhisky",newWhisky);
		return "index";
	}
	
	@PostMapping("/add-Whisky")
	public String addWhisky(@ModelAttribute Whisky whisky) {
		whiskyRepo.save(whisky);
		return "redirect:/";
	}
	
			
}
