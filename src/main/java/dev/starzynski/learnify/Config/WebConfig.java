package dev.starzynski.learnify.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String uploadDir = Paths.get("uploads/").toAbsolutePath().toUri().toString();

        registry.addResourceHandler("/uploads/**") // URL pattern
                .addResourceLocations(uploadDir);  // Actual folder path
    }
}

