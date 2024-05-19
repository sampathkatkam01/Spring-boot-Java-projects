package in.sampath.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sampath.customer.Customer;


public interface CustomerRepo extends JpaRepository<Customer, Integer> {


	public Customer findByEmail(String email);
}
