package project.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import project.Model.Entity.Whisky;
import project.Model.Repository.WhiskyRepo;

@Controller
public class ListController {

	@Autowired
	private WhiskyRepo whiskyRepo;
	
	

	@RequestMapping(value = "/list/{param}")
	public String ShowList(@PathVariable ("param") String param, Model model, Principal principal){
		List<Whisky> whiskys = null;
		String title = null;
		switch(param) {
			case "scotch":
			case "rye":
			case "japanese":
			case "bourbon":
				 title = param.substring(0, 1).toUpperCase() + param.substring(1) + " whisky";
				 whiskys = whiskyRepo.findAllByTypeIgnoreCase(param);
				break;
			case "toprated":
				 title = "Top rated whisky";
				 whiskys = whiskyRepo.findAllByOrderByTopOverallRanking();
				break;
			case "mostreviewed":
				 title = "Most reviewed whisky";
				 whiskys = whiskyRepo.findAllByOrderByMostReviewed();
				break;
			case "atoz":
				 title = "Whisky in alphabetical order";
				 whiskys = whiskyRepo.findAllByOrderByNameAsc();
				break;
			default:
				 whiskys = whiskyRepo.findAll();		
		}
		 model.addAttribute("title", title);
		 model.addAttribute("user",principal);
		 model.addAttribute("whiskys",whiskys);
		return "list";
	}
	
}
