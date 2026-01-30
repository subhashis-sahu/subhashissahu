package com.portfolio.subhashissahu.config;


import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecuritySpring {

    private final JwtFilter jwtFilter;

    SecuritySpring(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf(csrf->csrf.disable())
        .cors(cors->cors.configurationSource(corsConfigurationSource()))
        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(
            auth->auth.requestMatchers("/api/public/**").permitAll().requestMatchers("/api/health").permitAll()
            .requestMatchers("/api/admin/login","/api/admin/logout").permitAll()
            .requestMatchers("/api/admin/**").authenticated().anyRequest().denyAll())
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource()
    {
        CorsConfiguration conf=new CorsConfiguration();
        conf.setAllowedOrigins(List.of("https://subhashis-sahu.vercel.app","http://localhost:5173"));
        conf.setAllowedMethods(List.of("POST","GET","PUT","DELETE"));
        conf.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", conf);
        return source;
    }
    
}
