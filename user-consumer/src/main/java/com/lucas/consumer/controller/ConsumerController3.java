package com.lucas.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author Lucas
 * @Date 2019/12/18 17:53
 * @Version 1.0
 */
@RestController
@RequestMapping("/")
public class ConsumerController3 {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("findall2")
    public String findAll() {
        ServiceInstance instance = loadBalancerClient.choose("user-service");
        String host = instance.getHost();
        int port = instance.getPort();
//        return template.getForObject(SERVICEURL, String.class);
        String urlByEureka = "http://" + host + ":" + port + "/findall";
        return restTemplate.getForObject(urlByEureka, String.class);
    }

    @RequestMapping("findall3")
    public String findAll2() {
        return restTemplate.getForObject("http://user-service/findall",String.class);
    }

    @RequestMapping("findall4")
    public String findAll3() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://user-service/findall", String.class);
        HttpStatus statusCode = forEntity.getStatusCode();
        int statusCodeValue = forEntity.getStatusCodeValue();
        HttpHeaders headers = forEntity.getHeaders();
        String body = forEntity.getBody();
        StringBuilder result = new StringBuilder();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        return result.toString();
    }

}
