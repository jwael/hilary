package com.web.atrio.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.Clock;

/**
 * author: wael
 * v1 : Rest Api
 * date : 2022
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //documentation swagger : http://localhost:8080/swagger-ui.html
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("Fetching Person API documentation")
                                .title("Fetching Person REST API")
                                .build()
                )
                .groupName("REST API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.web.atrio.test"))
                .paths(PathSelectors.any())
                .build();
    }



    //clock to mock test using time
    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

}
