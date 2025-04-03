package spring.security.com.springsecurity.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.security.com.springsecurity.security.models.dto.LoginRequest;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private SecurityContextRepository securityContextRepository;

    @PostMapping("/login")
    public void login( @RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
        auth = authenticationManager.authenticate( auth );

        if (auth.isAuthenticated()) {

            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(auth);
            securityContextRepository.saveContext(context, request, response);

        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        securityContextRepository.saveContext(SecurityContextHolder.createEmptyContext(), request, response);
    }
}
