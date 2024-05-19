package in.sampath.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class configuration {

	@Bean
	public void filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()).oauth2Login();
	}

}
