package in.sampath.Service;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.sampath.customer.Customer;
import in.sampath.repo.CustomerRepo;

@Service
public class CustomerService implements UserDetailsService {

	@Autowired
	private CustomerRepo crepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer = crepo.findByEmail(email);
		return new User(customer.getEmail(), customer.getPwd(), Collections.emptyList());
	}

}
