package spring.security.com.springsecurity.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    public AuthenticationProvider authenticationProvider(AuthenticationService authenticationService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(authenticationService);
        provider.setPasswordEncoder(this.passwordEncoder());
        return provider;
    }

}
