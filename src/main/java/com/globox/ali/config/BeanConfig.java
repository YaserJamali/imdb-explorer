package com.globox.ali.config;


import org.springdoc.core.models.GroupedOpenApi;
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
                .pathsToMatch("/same-director-and-writer/**")
                .build();
    }


    @Bean
    public GroupedOpenApi movieWithTwoSameCategoryApi() {
        return GroupedOpenApi.builder()
                .group("Movies with Two Same Casts Categories")
                .pathsToMatch("/titles-of-casts/**")
                .build();

    }


//    @Bean
//    public GroupedOpenApi sameDirectorAndWriterAliveApi() {
//        return GroupedOpenApi.builder()
//                .group("Same Director and Writer Alive")
//                .pathsToMatch("/same-director-and-writer-alive/**]")
//                .build();
//    }

//    @Bean
//    public GroupedOpenApi sameDirectorAndWriterAliveWithoutBirthdayApi() {
//        return GroupedOpenApi.builder()
//                .group("Same Director and Writer Alive without Birthday")
//                .pathsToMatch("/same-director-and-writer-alive-without-birthday/[**")
//                .build();
//    }

    //    @Bean
//    public GroupedOpenApi movieWithTwoSameActorsApi() {
//        return GroupedOpenApi.builder()
//                .group("Movies with Two Same Actors")
//                .pathsToMatch("/movie-with-two-same-actors/[**")
//                .build();
//    }
    //
//    @Bean
//    public GroupedOpenApi titleBasicsApi() {
//        return GroupedOpenApi.builder()
//                .group("Title Basics")
//                .pathsToMatch("/title-basics/**")
//                .build();
//    }
//
//
//    @Bean
//    public GroupedOpenApi titleCrewApi() {
//        return GroupedOpenApi.builder()
//                .group("Title Crew")
//                .pathsToMatch("/title-crew/**")
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi titlePrincipalsApi() {
//        return GroupedOpenApi.builder()
//                .group("Title Principals")
//                .pathsToMatch("/title-principals/[**")
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi titleRatingsApi() {
//        return GroupedOpenApi.builder()
//                .group("Title Ratings")
//                .pathsToMatch("/title-ratings/**]")
//                .build();
//    }
}
