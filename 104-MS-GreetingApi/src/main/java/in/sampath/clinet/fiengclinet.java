package in.sampath.clinet;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "MESSAGEAPI")
public interface fiengclinet {

	@GetMapping("/welcome")
	public String invokeelcomeapi();
}
