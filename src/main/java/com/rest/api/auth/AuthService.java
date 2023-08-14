package com.rest.api.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rest.api.config.JwtService;
import com.rest.api.user.User;
import com.rest.api.user.UserDto;
import com.rest.api.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

        private final UserRepository repository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(RegisterRequest body) {
                var user = User.builder()
                                .firstName(body.getFirstName())
                                .lastName(body.getLastName())
                                .email(body.getEmail())
                                .password(passwordEncoder.encode(body.getPassword()))
                                .build();
                repository.save(user);
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();
        }

        public LoginResponse login(LoginRequest body) {
                authenticationManager
                                .authenticate(
                                                new UsernamePasswordAuthenticationToken(body.getEmail(),
                                                                body.getPassword()));
                var user = repository.findByEmail(body.getEmail()).orElseThrow();
                var userDto = UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
                var jwtToken = jwtService.generateToken(user);
                return new LoginResponse(jwtToken, userDto);

        }

}
