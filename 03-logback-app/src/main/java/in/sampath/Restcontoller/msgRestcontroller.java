package in.sampath.Restcontoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import in.sampath.service.msgservice;

@RestController
public class msgRestcontroller {
	@Autowired
	private msgservice msgservice;

	@GetMapping("/welcome")
	public String getmsg() {
		return msgservice.getWelcomeMsg();
	}
}
