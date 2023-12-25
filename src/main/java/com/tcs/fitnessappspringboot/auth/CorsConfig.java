package com.tcs.fitnessappspringboot.auth;


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
        registry.addMapping("/api/**") // Specify the mapping for which CORS should be enabled
            .allowedOrigins("http://localhost:3000") // Specify the allowed origin(s)
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify the allowed HTTP methods
            .allowedHeaders("*"); // Specify the allowed headers
    }
}
