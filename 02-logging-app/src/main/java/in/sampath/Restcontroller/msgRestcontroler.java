
package in.sampath.Restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sampath.service.MsgService;

@RestController
public class msgRestcontroler {
	@Autowired
	private MsgService msgservice;
	
	@GetMapping("/welcome")
	public String getmsg() {
		return msgservice.getWelcomeMsg();
	}

}
