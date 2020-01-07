package com.lucas.consumer.controller;

import com.zpark.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author Lucas
 * @Date 2019/12/18 11:04
 * @Version 1.0
 */
@RestController
@RequestMapping("/")
public class ConsumerController {
    private String SERVICEURL = "http://localhost:8081/findall";
    @Autowired
    RestTemplate template;

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("findall")
    public String findAll() {
//        return template.getForObject(SERVICEURL, String.class);

        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        String urlByEureka = "http://" + host + ":" + port + "/findall";

        return template.getForObject(urlByEureka, String.class);

    }
}
