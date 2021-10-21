package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);
        ApplicationContext appContext = SpringApplication.run(
                DemoApplication.class, args);
        RecommenderImplementation recommender = appContext.getBean(
                RecommenderImplementation.class);
        String[] result = recommender.recommendMovies("Finding Dory");
        System.out.println(Arrays.toString(result));
    }

}
