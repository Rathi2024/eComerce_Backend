package com.rathi.ecom_project.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("E-Commerce Backend API")
                        .version("1.0")
                        .description("Secure REST API built with Spring Boot, JWT Authentication, Role-Based Authorization, Product CRUD, Image Upload, Validation, and Global Exception Handling.")
                        .contact(new Contact()
                                .name("Prajjwal Rathi")
                                .email("your-email@example.com")
                                .url("https://github.com/Rathi2024")
                        )
                )

                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))

                .components(new Components()
                        .addSecuritySchemes(
                                "Bearer Authentication",
                                new SecurityScheme()
                                        .name("Bearer Authentication")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                );

    }

}
