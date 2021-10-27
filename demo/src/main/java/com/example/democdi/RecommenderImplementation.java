package com.example.democdi;

import com.example.other.Assets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

@Component
@ComponentScan(basePackages = "com.example.other")
@Slf4j
/*@ComponentScan(basePackages = "com.example",
        includeFilters = @ComponentScan.Filter(
        type = FilterType.REGEX,
        pattern = "haha.example.*"))*/
public class RecommenderImplementation {
    private Filter filter;

    //@Autowired
    /*public RecommenderImplementation(@Qualifier("CBF") Filter filter) {
        super();
        this.filter = filter;
    }*/

    @Inject
    @Qualifier("CBF")
    public void setFilter(Filter filter) {
        log.info("In RecommenderImplementation setter method..dependency injection");
        this.filter = filter;
    }

    private Assets assets;
    @Autowired
    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    @PostConstruct
    public void postConstruct() {
       log.info("Post construct!");
    }

    @PreDestroy
    public void preDestroy() {
       log.info("Pre destroy!");
    }

    public String[] recommendMovies (String movie) {
        System.out.println("Name of the filter in use: " + filter + "\n");
        //String[] results = filter.getRecommendations("Finding Dory");
        String[] results = filter.getRecommendations("Finding Dory");
        assets.getDesc();;
        //return the results
        return results;
    }
}
