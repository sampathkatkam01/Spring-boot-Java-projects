package in.sampath.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class AppSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager inMemUsers() {

		@SuppressWarnings("deprecation")
		UserDetails u1 = User.withDefaultPasswordEncoder()
				.username("john").password("john@123")
				.roles("ADMIN")
				.build();

		@SuppressWarnings("deprecation")
		UserDetails u2 = User.withDefaultPasswordEncoder()
				.username("smith")
				.password("smith@123")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(u1, u2);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(
				(authorize) -> authorize.requestMatchers("/deposit", "/about").permitAll().anyRequest().authenticated())
				.formLogin(withDefaults());
		return http.build();
	}
}
