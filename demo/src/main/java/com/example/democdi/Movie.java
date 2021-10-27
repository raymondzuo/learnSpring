package com.example.democdi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Slf4j
public class Movie {
    private static int instances = 0;

    private int id;
    private String name;
    private String genre;
    private String producer;

    public Movie() {
        super();
        instances++;
        log.info("Movie constructor called");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("Post construct of Movie!");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("Pre destroy of Movie!");
    }

    public static int getInstances() {
        return Movie.instances;
    }
}
