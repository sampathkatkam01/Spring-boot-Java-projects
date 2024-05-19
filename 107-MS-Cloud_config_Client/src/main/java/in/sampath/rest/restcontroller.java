package in.sampath.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restcontroller {

	@Value("${msg}")
	private String text;

	@GetMapping("/welcome")
	public String msg() {
		return text;
	}
}
