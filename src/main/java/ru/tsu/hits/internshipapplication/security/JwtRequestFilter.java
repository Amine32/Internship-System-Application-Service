package ru.tsu.hits.internshipapplication.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final WebClient.Builder webClientBuilder;

    private static final List<String> EXCLUDED_PATHS = Arrays.asList("/swagger-ui", "/v3/api-docs", "/swagger-ui.html", "/webjars", "/v2", "/swagger-resources");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        // Skip JWT extraction and validation for excluded paths
        if (EXCLUDED_PATHS.stream().noneMatch(path::startsWith)) {

            final String authorizationHeader = request.getHeader("Authorization");

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String jwt = authorizationHeader.substring(7);

                // Call the validation endpoint
                Boolean isValid = webClientBuilder.build()
                        .post()
                        .uri("https://hits-user-service.onrender.com/api/validate")
                        .body(Mono.just(jwt), String.class)
                        .retrieve()
                        .bodyToMono(Boolean.class)
                        .block();

                if (!isValid) {
                    // Token is not valid, reject the request
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
            }
        }

        chain.doFilter(request, response);
    }
}
