package com.example.Jour4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Jour4.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // @Bean
    // public InMemoryUserDetailsManager userDetailsService() {
    //     UserDetails user1 = User.withUsername("user")
    //             .password(passwordEncoder().encode("user"))
    //             .roles("USER")
    //             .build();
    //     UserDetails admin = User.withUsername("admin")
    //             .password(passwordEncoder().encode("admin"))
    //             .roles("ADMIN")
    //             .build();
    //     return new InMemoryUserDetailsManager(user1, admin);
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console").hasRole("ADMIN")
                        .requestMatchers("/delete/**").hasRole("ADMIN")
                        .requestMatchers("/update/**").hasRole("ADMIN")
                        .requestMatchers("/edit/**").hasRole("ADMIN")
                        .requestMatchers("/anonymous*").anonymous()
                        .requestMatchers("/","/welcome", "/login", "/register", "/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/perform_login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error=true")
                        .failureHandler(authenticationFailureHandler()))
                .logout(logout -> logout
                        .logoutUrl("/perform_logout")
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessHandler(logoutSuccessHandler()))
                .exceptionHandling(ex -> ex
                        .accessDeniedPage("/error/403"));
        return http.build();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        SimpleUrlLogoutSuccessHandler handler = new SimpleUrlLogoutSuccessHandler();
        handler.setDefaultTargetUrl("/login");
        return handler;
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> userRepository.findByUsername(username)
            .map(user -> User.withUsername(user.getUsername())
                             .password(user.getPassword())
                             .roles(user.getRole()) 
                             .build())
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    

}