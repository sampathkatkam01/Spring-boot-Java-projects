package in.sampath.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restcontroller {

	@GetMapping("/")
	public String getmsg() {
		return "Welcome to the Web app";
	}
}
