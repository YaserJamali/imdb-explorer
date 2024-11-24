package com.globox.ali.config;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


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
    } @Bean
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
