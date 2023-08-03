package com.example.accessingdatajpa.config.token;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "jwt")
@Component
public class JwtProperties {
    private String header;
    private String secret;
    private Long accessTokenValidityInSeconds;
}