package com.isamrs.backend.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/location/all")
                .allowedOrigins("http://127.0.0.1:5173");
        registry.addMapping("/api/passenger/register")
                .allowedOrigins("http://127.0.0.1:5173");
        registry.addMapping("/api/passenger/activate/{email}")
                .allowedOrigins("http://127.0.0.1:5173");
        registry.addMapping("/api/passenger/resetPassword/{email}")
                .allowedOrigins("http://127.0.0.1:5173");
        registry.addMapping("/api/passenger/{id}")
                .allowedOrigins("http://127.0.0.1:5173");
        registry.addMapping("/api/passenger/edit")
                .allowedOrigins("http://127.0.0.1:5173");
    }
}
