package in.sampath.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private Environment env;

	@GetMapping("/welcome")
	public String welcommsg() {

		String port = env.getProperty("server.port");
		String ms = "Welcome to app of sampath(" + port + ")";
		return ms;
	}
}
