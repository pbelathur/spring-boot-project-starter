package com.example.projectstarter.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {

        return new ApiInfo("My REST API",
                           "Some custom description of API.",
                           "MVP",
                           "Terms of service",
                           new Contact("John Doe",
                                       "www.example.com",
                                       "myeaddress@company.com"),
                           "License of API",
                           "API license URL",
                           Collections.emptyList());
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        SwaggerFilter swaggerFilter = new SwaggerFilter();
        filterRegistrationBean.setFilter(swaggerFilter);
        return filterRegistrationBean;
    }
}