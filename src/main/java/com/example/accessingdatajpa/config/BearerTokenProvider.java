package com.example.accessingdatajpa.config;

import java.time.Instant;

import com.example.accessingdatajpa.user.entity.User;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@RequiredArgsConstructor
public class BearerTokenProvider {
    private final JwtEncoder jwtEncoder;

    public String createBearerToken(User user) {
        Instant now = Instant.now();
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .issuer("https://realworld.io")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(300))
                .subject(user.getUser_id().toString())
                .build();

        JwtEncoderParameters parameters = JwtEncoderParameters.from(claimsSet);
        String token = jwtEncoder.encode(parameters).getTokenValue();
        log.debug("Generated bearer token with user id `{}`: {}", user.getUser_id(), token);

        return token;
    }
}
