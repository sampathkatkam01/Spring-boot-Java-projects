package in.sampath.rest;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restcontorller {

	private HashOperations<String, Object, Object> opsforhash;

	public Restcontorller(RedisTemplate<String, String> rt) {
		this.opsforhash = rt.opsForHash();
	}

	@PostMapping("/user")
	public String saveData() {
		opsforhash.put("USERS", 102, "sampath");
		return "data saved";
	}

	@GetMapping("/user")
	public String getUserName() {
		System.out.println(opsforhash.get("USERS", 102));
		return (String) opsforhash.get("USERS", 102);
	}

	@GetMapping("/users")
	public Map<Object, Object> getAllUsers() {
		System.out.println(opsforhash.entries("USERS"));
		return opsforhash.entries("USERS");
		
	}

}
