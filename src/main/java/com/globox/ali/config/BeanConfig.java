package com.globox.ali.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Value("${springdoc.info.title}")
    private String title;

    @Value("${springdoc.info.description}")
    private String description;

    @Value("${springdoc.info.version}")
    private String version;

    @Value("${springdoc.info.contact.name}")
    private String contactName;

    @Value("${springdoc.info.contact.url}")
    private String contactUrl;

    @Value("${springdoc.info.contact.email}")
    private String contactEmail;

    @Value("${springdoc.info.license.name}")
    private String licenseName;

    @Value("${springdoc.info.license.url}")
    private String licenseUrl;
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .description(description)
                        .version(version)
                        .contact(new Contact()
                                .name(contactName)
                                .url(contactUrl)
                                .email(contactEmail))
                        .license(new License()
                                .name(licenseName)
                                .url(licenseUrl)));
    }

    @Bean
    public GroupedOpenApi bestMoviesOfTheYearApi() {
        return GroupedOpenApi.builder()
                .group("Best Movies of the Year")
                .pathsToMatch("/best-movies-of-the-year/**")
                .build();
    }
    @Bean
    public GroupedOpenApi sameDirectorAndWriterApi() {
        return GroupedOpenApi.builder()
                .group("Same Director and Writer")
                .pathsToMatch("/same-director-writer/**")
                .build();
    }
    @Bean
    public GroupedOpenApi movieWithTwoSameCategoryApi() {
        return GroupedOpenApi.builder()
                .group("Movies with Two Same Casts Categories")
                .pathsToMatch("/titles-of-casts/**")
                .build();
    }
    @Bean
    public GroupedOpenApi httpServletCounter() {
        return GroupedOpenApi.builder()
                .group("This Api gives The Number Of Http Requests")
                .pathsToMatch("/http-handler/**")
                .build();
    }
    @Bean
    public GroupedOpenApi inoutDataFromFileApi() {
        return GroupedOpenApi.builder()
                .group("APIs for importing data into tables")
                .pathsToMatch("/input-to-tables/**")
                .build();
    }
    @Bean
    public FilterRegistrationBean<FilterWrapper> filterWrapperFilterRegistrationBean() {
        FilterRegistrationBean<FilterWrapper> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new FilterWrapper());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

}
