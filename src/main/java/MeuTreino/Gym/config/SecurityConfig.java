package MeuTreino.Gym.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import MeuTreino.Gym.tokenJwt.JWTTokenProvider;
import MeuTreino.Gym.tokenJwt.JwtTokenFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	UserDetailsServiceImpl detailsServiceImpl;
	
	
	@Autowired
	private JWTTokenProvider jwtTokenProvider;

	public SecurityConfig(UserDetailsServiceImpl detailsServiceImpl) {
		this.detailsServiceImpl = detailsServiceImpl;
	}

//	@Bean
//	public SecurityFilterChain chain(HttpSecurity http) throws Exception{
//		http
//			.csrf((csrf) -> csrf.disable())
//			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//			.authorizeHttpRequests(auth -> auth 
//					.requestMatchers("/login").permitAll()
//					.requestMatchers("/home").hasRole("ADMIN")
//					.anyRequest().authenticated()
//					)
//            .httpBasic(withDefaults());
//		return http.build();
//	}
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
    	JwtTokenFilter customFilter = new JwtTokenFilter(jwtTokenProvider);
        return http
                .httpBasic(basic -> {basic.disable();})
                .csrf(csrf -> {csrf.disable();})
                .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(
            		session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                    authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/home").authenticated()
                        .requestMatchers("/users").denyAll()
                )
                .cors( cors -> {})
                .build();
 
    }
	
	
	@Bean
	public AuthenticationManager authenticationManager 
	(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
