package tech.sigpay.config.auth;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.sigpay.config.auth.dtos.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final GoogleAuthService googleAuthService;
    private final UserDetailsService userDetailsService;

    public AuthController(AuthService authService, GoogleAuthService googleAuthService, UserDetailsService userDetailsService) {
        this.authService = authService;
        this.googleAuthService = googleAuthService;
        this.userDetailsService = userDetailsService;
    }

    // Futuramente!
    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginRequestDTO dto) {
        return authService.login(dto);
    }
    @PostMapping("/register")
    public AuthResponseDTO register(@RequestBody RegisterRequestDTO dto) {
        return authService.register(dto);
    }

    @PostMapping("/google")
    public AuthResponseDTO loginWithGoogle(@RequestBody GoogleLoginDTO dto) throws Exception {
        return googleAuthService.authenticateWithGoogle(dto.getIdToken());
    }

    @PostMapping("/refresh")
    public AuthResponseDTO refresh(@RequestBody RefreshTokenDTO dto) {
        String username = authService.extractUsername(dto.refreshToken());
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(username);

        return authService.refreshToken(dto.refreshToken(), userDetails);
    }

}