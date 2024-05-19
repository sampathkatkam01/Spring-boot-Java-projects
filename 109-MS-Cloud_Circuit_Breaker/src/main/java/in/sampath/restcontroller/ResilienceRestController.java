package in.sampath.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class ResilienceRestController {

	@GetMapping("/data")
	@CircuitBreaker(fallbackMethod = "GetDataFromDb", name = "DBcircuit")
	public String getData() {

		System.out.println("Redies method called here.........");

		int i = 10 / 0;
		return "Redis data sent to mail";

	}

	public String GetDataFromDb(Throwable t) {
		System.out.println("Database method executed..");

		return "DB details sent to mail";
	}
}
