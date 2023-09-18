package com.quizplayground.quizplayground.utils;

import java.util.Arrays;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfiguration {

  @Bean
  public CorsFilter corsFilter() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    final org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();

    config.setAllowCredentials(true);
    config.setAllowedOrigins(Collections.singletonList("http://localhost:5173"));
    config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
    config.setAllowedMethods(
        Arrays.asList("GET", "POST", "PUT", "PATCH", "OPTIONS", "DELETE", "HEAD"));

    source.registerCorsConfiguration("/**", config);

    return new CorsFilter(source);
  }
}
