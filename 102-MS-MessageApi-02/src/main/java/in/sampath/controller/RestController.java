package in.sampath.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;

import com.netflix.discovery.converters.Auto;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private Environment env;
	
	@GetMapping("/welcome")
	public String getmsg() {
		
		String port = env.getProperty("server.port");
		String ms="Welcome to app ("+port+")";
		return ms;
	}

}
