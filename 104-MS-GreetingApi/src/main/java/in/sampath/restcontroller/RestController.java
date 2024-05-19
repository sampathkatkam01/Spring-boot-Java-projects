package in.sampath.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import in.sampath.clinet.fiengclinet;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private fiengclinet clinent;

	@GetMapping("")
	public String greet() {
		String welcome = clinent.invokeelcomeapi();
		String ms="greet sampath";
		return ms+welcome;
	}
}
