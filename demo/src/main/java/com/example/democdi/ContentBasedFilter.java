package com.example.democdi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

@Named
@Qualifier("CBF")
@Slf4j
public class ContentBasedFilter implements Filter {
    private static int instances = 0;

    @Autowired
    private Movie movie;

    public ContentBasedFilter() {
        super();
        instances++;
        log.info("ContentBasedFilter constructor called");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("Post construct of ContentBasedFilter!");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("Pre destroy! of CBF");
    }

    @Lookup
    public Movie getMovie() {
        return null;
    }

    public static int getInstances(){
        return ContentBasedFilter.instances;
    }

    public String[] getRecommendations(String movie) {
        //logic of content based filter
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
