package com.zipkin.client;

import com.zipkin.client.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by esha on 25/05/18.
 */

@Controller
public class ClientController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private DetailService detailService;

    @GetMapping("/rest/v1/client")
    @ResponseBody
    public String getClientInformation() throws UnknownHostException {

        System.out.println("Request received to get server detail. ");

        InetAddress localhost = InetAddress.getLocalHost();

        StringBuilder sb = new StringBuilder("Client Information ");
        sb.append("\n")
                .append("Application: ").append(appName).append("\n")
                .append("IP Address: ").append(localhost.getHostAddress()).append("\n")
                .append(", Total Memory: ").append(Runtime.getRuntime().totalMemory() / 1024).append("M").append("\n")
                .append(", Free Memory: ").append(Runtime.getRuntime().freeMemory() / 1024).append("M").append("\n")
                .append(", Total Processor: ").append(Runtime.getRuntime().availableProcessors());

        String clientInformation = sb.append("\n\n\n").toString();

        System.out.println("About to get server information");
        String serverResponse = detailService.getServerDetail();
        return clientInformation + serverResponse;
    }
}
