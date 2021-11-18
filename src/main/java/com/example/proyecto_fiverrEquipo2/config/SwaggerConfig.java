package com.example.proyecto_fiverrEquipo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    /**
     * Configuración swagger ui
     * http://localhost:8080/swagger-ui/
     */

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails() {
        return new ApiInfo("Spring Boot Jobs API REST", " Jobs Api rest docs", "1.0", "http://www.google.es", new Contact("Equipo2", "http://www.google.es", "equipo2@example.es"), "MIT", "http://www.google.es", Collections.emptyList());
}

}
