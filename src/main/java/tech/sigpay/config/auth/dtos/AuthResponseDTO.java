package tech.sigpay.config.auth.dtos;

public record AuthResponseDTO(
        String accessToken,
        String refreshToken,
        String message
) {
}
