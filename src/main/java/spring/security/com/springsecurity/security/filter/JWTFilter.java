package spring.security.com.springsecurity.security.filter;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import spring.security.com.springsecurity.security.models.exceptions.CookieNotFoundException;
import spring.security.com.springsecurity.security.services.AuthenticationService;
import spring.security.com.springsecurity.security.utils.CookieUtils;
import spring.security.com.springsecurity.security.utils.JWTUtils;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final CookieUtils cookieUtils = new CookieUtils();
    private final JWTUtils jwtUtils = new JWTUtils();

    private AuthenticationService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {

            Cookie cookie = cookieUtils.getJWTCookie(request);
            String token = cookie.getValue();
            jwtUtils.validateToken(token);

            String username = jwtUtils.getUsernameFromToken(token);

            UserDetails userDetails = authService.loadUserByUsername(username);
            Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(auth);

        } catch ( CookieNotFoundException e ) {
            filterChain.doFilter(request, response);
        } catch ( TokenExpiredException | SignatureVerificationException e ) {
            response.setStatus(403);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
