package spring.security.com.springsecurity.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import spring.security.com.springsecurity.security.services.AuthenticationService;

@Configuration
public class SecurityConfig {

    /*@Bean
    public UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.builder()
                .username("admin")
                .password("admin")
                .build()
        );

        manager.createUser(User.builder()
                .username("user")
                .password("user")
                .build()
        );

        return manager;
    }*/

    // @Bean --> Injeção de dependência (Não precisa mais já que o método abaixo está injetando)
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationService authenticationService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(authenticationService);
        provider.setPasswordEncoder(this.passwordEncoder());
        return new ProviderManager(provider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin( config -> config.disable())
                .csrf(config -> config.disable())
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers( HttpMethod.POST, "api/auth/login", "api/auth/logout").permitAll()
                            .anyRequest().authenticated();
                })
                .build();
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {

        return new HttpSessionSecurityContextRepository();

    }

}
