package tech.sigpay.config.auth.dtos;

public record RegisterRequestDTO(
        String name,
        String email,
        String password
) {
}
