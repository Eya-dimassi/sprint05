package com.eya.pays.security;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
	/*@Bean
    public InMemoryUserDetailsManager userDetailsService() {
		PasswordEncoder passwordEncoder = passwordEncoder ();

		 UserDetails admin = User
		 .withUsername("admin")
		 .password(passwordEncoder.encode("123"))
		 .authorities("ADMIN")
		 .build();
		 UserDetails userEya = User
		 .withUsername("eya")
		 .password(passwordEncoder.encode("123"))
		 .authorities("AGENT","USER")
		 .build();
		 UserDetails user1 = User
		 .withUsername("user1")
		 .password(passwordEncoder.encode("123"))
		 .authorities("USER")
		 .build();

		 return new InMemoryUserDetailsManager(admin, userEya,user1);
    }*/
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
	    http.authorizeHttpRequests((requests) -> requests
	            .requestMatchers("/login", "/webjars/**").permitAll() // allow login page + static resources
	            .requestMatchers("/showCreate", "/savePays").hasAnyAuthority("ADMIN", "AGENT")
	            .requestMatchers("/modifierPays", "/updatePays", "/deletePays").hasAuthority("ADMIN")
	            .requestMatchers("/ListePays").hasAnyAuthority("ADMIN", "AGENT", "USER")
	            .requestMatchers("/supprimerPays").hasAuthority("ADMIN")
	            .anyRequest().authenticated()
	        )
	        .formLogin((formLogin) -> formLogin
	            .loginPage("/login")             // custom login page
	            .defaultSuccessUrl("/")           // after login success, go to home page "/"
	            .permitAll()
	        )
	        .httpBasic(Customizer.withDefaults())   // basic auth for API if needed
	        .exceptionHandling((exception) -> exception
	            .accessDeniedPage("/accessDenied")  // custom access denied page
	        );

	    return http.build();
	}
	@Bean
	 public PasswordEncoder passwordEncoder () {
	 return new BCryptPasswordEncoder();
	 }
	/*@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
	JdbcUserDetailsManager jdbcUserDetailsManager =new
	JdbcUserDetailsManager(dataSource);

	jdbcUserDetailsManager.setUsersByUsernameQuery("select username,password, enabled from user where username =?");
	jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT u.username, r.role as authority " +
	 "FROM user_role ur, user u , role r " +
	"WHERE u.user_id = ur.user_id AND ur.role_id = r.role_id AND u.username = ?");

	 return jdbcUserDetailsManager;
	 }*/
	
}
