package com.eya.pays.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .authorities("ADMIN")
                .build();

        UserDetails userEya = User.withDefaultPasswordEncoder()
                .username("eya")
                .password("123")
                .authorities("AGENT", "USER")
                .build();

        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("user1")
                .password("123")
                .authorities("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, userEya, user1);
    }
	@Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests

                // Autorisation selon rôles :
                .requestMatchers("/showCreate", "/savePays").hasAnyAuthority("ADMIN", "AGENT")
                .requestMatchers("/modifierPays", "/updatePays", "/deletePays").hasAuthority("ADMIN")
                .requestMatchers("/ListePays").hasAnyAuthority("ADMIN", "AGENT", "USER")

                // Toute autre requête nécessite une auth
                .anyRequest().authenticated())

                // Formulaire login par défaut
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .exceptionHandling((exception)-> exception.accessDeniedPage("/accessDenied"));

                                                                       
        return http.build();
    }
}
