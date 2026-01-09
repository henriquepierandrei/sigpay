package tech.sigpay.config.auth.dtos;

public record LoginRequestDTO(
        String email,
        String password
) {
}
