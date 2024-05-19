package in.sampath.Cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sampath.client.WelcomeApiFienclinet;

@RestController
public class greetController {

	@Autowired
	private WelcomeApiFienclinet client;
	@Autowired
	private Environment env;

	@GetMapping("/greet")
	public String greetmsg() {
		String welcomeApi = client.invokeWelcomeApi();
		String port = env.getProperty("server.port");
		String greetapi = "Good morning , ("+port+")";
		return greetapi+welcomeApi;
	}
}
