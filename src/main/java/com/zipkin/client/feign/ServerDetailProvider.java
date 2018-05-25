package com.zipkin.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by esha on 25/05/18.
 */
@FeignClient(url = "http://localhost:8080", serviceId = "zipkin-server")
public interface ServerDetailProvider {

    @GetMapping("/rest/v1/servers")
    public String getServerInformation();
}
