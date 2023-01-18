package oec.lis.sopl.common.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


public class SecurityConfig {

    @Value("${security.cors.allowed-methods}") 
    private String[] corsAllowedMethods;

    @Value("${security.cors.allowed-origins}")
    private String[] securityCorsAllowedOrigins;

    @Value("${security.ignore-security-check-uri-list}")
    private String[] ignoreSecurityCheckUriList;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("*");
        configuration.setAllowedOriginPatterns(Arrays.asList(securityCorsAllowedOrigins));
        configuration.setAllowedMethods(Arrays.asList(corsAllowedMethods));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}
