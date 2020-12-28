package project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	
	@GetMapping("/hello")
	public String sayHello() {
		return "OSTATECZNA PROBA";
	}
}
