package com.zipkin.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zipkin.client.feign.ServerDetailProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by esha on 25/05/18.
 */
@Service
public class DetailService {

    @Autowired
    private ServerDetailProvider serverDetailProvider;


    @HystrixCommand(fallbackMethod = "notReachable")
    public String getServerDetail() {
        System.out.println("In DetailService getServerDetail method.");
        return serverDetailProvider.getServerInformation();
    }

    private String notReachable() {
        System.out.println("Server not reachable!");
        return "Server not reachable, returning some static content!";
    }
}
