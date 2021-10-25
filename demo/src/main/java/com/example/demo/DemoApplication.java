package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import javax.xml.ws.ServiceMode;
import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);
        ApplicationContext appContext = SpringApplication.run(
                DemoApplication.class, args);
        RecommenderImplementation recommender = appContext.getBean(
                RecommenderImplementation.class);
        //ContentBasedFilter cbf1 = appContext.getBean(ContentBasedFilter.class);
        //ContentBasedFilter cbf2 = appContext.getBean(ContentBasedFilter.class);
        //ContentBasedFilter cbf3 = appContext.getBean(ContentBasedFilter.class);
        //System.out.println("cbf1:" + cbf1);
        //System.out.println("cbf2:" + cbf2);
        //System.out.println("cbf3:" + cbf3);

        //CollaborativeFilter cf1 = appContext.getBean(CollaborativeFilter.class);
        //CollaborativeFilter cf2 = appContext.getBean(CollaborativeFilter.class);
        //CollaborativeFilter cf3 = appContext.getBean(CollaborativeFilter.class);
        //System.out.println("cf1:" + cf1);
        //System.out.println("cf2:" + cf2);
        //System.out.println("cf3:" + cf3);
        ContentBasedFilter cbf = appContext.getBean(ContentBasedFilter.class);
        System.out.println("cbf: " + cbf);
        Movie mv1 = cbf.getMovie();
        Movie mv2 = cbf.getMovie();
        Movie mv3 = cbf.getMovie();
        System.out.println("mv1: " + mv1);
        System.out.println("mv2: " + mv2);
        System.out.println("mv3: " + mv3);

        System.out.println("instance of cbf: " + ContentBasedFilter.getInstances());
        System.out.println("instance of movie: " + Movie.getInstances());

        String[] result = recommender.recommendMovies("Finding Dory");
        System.out.println(Arrays.toString(result));

        Movie mv5 = appContext.getBean(Movie.class);
        log.info("mv5" + mv5);
        Movie mv6 = appContext.getBean(Movie.class);
        log.info("mv6" + mv6);
    }

}
