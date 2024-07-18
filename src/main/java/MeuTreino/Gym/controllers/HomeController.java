package MeuTreino.Gym.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("/home")
	public String  HomePage () {
		return ("login word Gym Page");
	}

}
