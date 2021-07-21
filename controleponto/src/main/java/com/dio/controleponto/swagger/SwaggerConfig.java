package com.dio.controleponto.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com.dio.controleponto.api.rest")
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.ant("/**"))
        .build()
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    String description = "REST API Boneto";
    return new ApiInfoBuilder()
        .title("API-REST")
        .description(" API de Controle de Acesso")
        .version("1.0.0")
        .termsOfServiceUrl("")
        .license("Apache License Version 2.0")
        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
        .contact(new Contact("Alexandre Boneto", "https://www.linkedin.com/in/alexandre-boneto-69b29b43/", "oaboneto@gmail.com.br"))
        .build();
  }
}


