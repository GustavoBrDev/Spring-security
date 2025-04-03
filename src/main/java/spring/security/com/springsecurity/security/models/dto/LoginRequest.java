package spring.security.com.springsecurity.security.models.dto;

public record LoginRequest(
        String username,
        String password
) {
}
