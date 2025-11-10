package com.testp.spotlessapp.api;

// Avoid wildcard imports: io.swagger.v3.oas.models.*
// Avoid wildcard imports: io.swagger.v3.oas.models.info.*
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI userApi() {
    return new OpenAPI()
        .info(
            new Info()
                .title("User API")
                .version("1.0.0")
                .description("API for user registration and login"));
  }
}
