package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {
    private Filter filter;

    //@Autowired
    /*public RecommenderImplementation(@Qualifier("CBF") Filter filter) {
        super();
        this.filter = filter;
    }*/

    @Autowired
    public void setFilter(@Qualifier("CF") Filter filter) {
        this.filter = filter;
    }

    public String[] recommendMovies (String movie) {
        System.out.println("Name of the filter in use: " + filter + "\n");
        //String[] results = filter.getRecommendations("Finding Dory");
        String[] results = filter.getRecommendations("Finding Dory");
        //return the results
        return results;
    }
}
