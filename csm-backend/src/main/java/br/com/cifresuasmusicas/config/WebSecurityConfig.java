package br.com.cifresuasmusicas.config;

import br.com.cifresuasmusicas.handler.LoggingAccessDeniedHandler;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    private static final String[] AUTH_WHITE_LIST = {
        "/**"
    };

    private static final String[] DEV_AUTH_WHITE_LIST = {
        "/**",
        "/h2-console/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            //.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth ->
                auth.requestMatchers(AUTH_WHITE_LIST).permitAll()
                    .anyRequest().authenticated())
            .exceptionHandling(except -> except.accessDeniedHandler(accessDeniedHandler()))
            .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Profile("dev")
    public SecurityFilterChain devFilterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher(PathRequest.toH2Console())
            .authorizeHttpRequests(auth -> auth.requestMatchers(DEV_AUTH_WHITE_LIST).permitAll())
            .csrf(AbstractHttpConfigurer::disable)
            .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
            .exceptionHandling(except -> except.accessDeniedHandler(accessDeniedHandler()))
            .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new LoggingAccessDeniedHandler();
    }
}