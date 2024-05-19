package in.sampath.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.sampath.Service.CustomerService;

@Configuration
@EnableWebSecurity
public class config {

	@Autowired
	private CustomerService CService;

	@Bean
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public AuthenticationProvider authprovider() {
		DaoAuthenticationProvider authprovider = new DaoAuthenticationProvider();
		authprovider.setUserDetailsService(CService);
		authprovider.setPasswordEncoder(pwdEncoder());
		return authprovider;
	}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
	@Bean
	public SecurityFilterChain securityconfig(HttpSecurity http) throws Exception{
		return http.csrf(csrf -> csrf
                .disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/register", "/login")
                        .permitAll())
                .build();
	}
}
