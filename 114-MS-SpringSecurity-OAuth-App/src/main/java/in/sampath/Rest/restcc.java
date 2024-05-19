package in.sampath.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restcc {

	@GetMapping("/")
	public String welcomeapp() {
		return "Welcome to OAuth_security_APP";
	}

}
