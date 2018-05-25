package com.zipkin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Created by esha on 24/05/18.
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class Application {
    protected Application(){

    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

