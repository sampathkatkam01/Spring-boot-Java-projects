package in.sampath.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restcontroller {

	
		@GetMapping("/deposit")
		public String deposit() {
			return "Money deposited";
		}
		
		@GetMapping("/withdraw")
		public String withdraw() {
			return "Money withdrawed from account11";
		}
		
		@GetMapping("/about")
		public String about() {
			return "Bank Of BORODA withdrawed from account";
		}

	}


