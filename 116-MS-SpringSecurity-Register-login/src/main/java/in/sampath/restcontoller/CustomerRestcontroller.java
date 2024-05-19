package in.sampath.restcontoller;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sampath.customer.Customer;
import in.sampath.repo.CustomerRepo;

@RestController
public class CustomerRestcontroller {

	@Autowired
	private CustomerRepo crepo;
	@Autowired
	private PasswordEncoder pwdencoder;
	@Autowired
	private AuthenticationManager authManager;

	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody Customer c) {
		String encodedpwd = pwdencoder.encode(c.getPwd());
		c.setPwd(encodedpwd);
		crepo.save(c);
		return new ResponseEntity<String>("User registered", HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginCheck(@RequestBody Customer c) {

		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(c.getEmail(), c.getPwd());

		try {
			Authentication authenticate = authManager.authenticate(token);

			if (authenticate.isAuthenticated()) {
				return new ResponseEntity<String>("Welcome To sampathKatkam APP", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<String>("Invalid Credentials", HttpStatus.BAD_REQUEST);
	}
}
