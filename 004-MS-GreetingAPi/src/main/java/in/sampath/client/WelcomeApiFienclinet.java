package in.sampath.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "WELCOME-API")
public interface WelcomeApiFienclinet {
	
	@GetMapping("/welcome")
	public String invokeWelcomeApi();

}
