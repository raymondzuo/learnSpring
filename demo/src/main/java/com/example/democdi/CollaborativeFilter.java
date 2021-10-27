package com.example.democdi;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("CF")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CollaborativeFilter implements Filter {
    public String[] getRecommendations(String movie) {
        //logic of collaborative filter
        return new String[] { };
    }
}
