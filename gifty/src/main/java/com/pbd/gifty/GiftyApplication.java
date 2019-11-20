package com.pbd.gifty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.io.File;

@SpringBootApplication
public class GiftyApplication {

    @Value("${multipart.location}/gif/")
    private String gifLocation;

    public static void main(String[] args) {
        SpringApplication.run(GiftyApplication.class, args);
    }



    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer () {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/gif/**")
                        .addResourceLocations("file:" + gifLocation);
                WebMvcConfigurer.super.addResourceHandlers(registry);
            }
        };
    }

}
