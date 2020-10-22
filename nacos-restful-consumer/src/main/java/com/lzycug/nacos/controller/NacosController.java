package com.lzycug.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * description：
 * author：lzyCug
 * date: 2020/10/22 11:24
 */
@RestController
@RequestMapping("/nacos")
public class NacosController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private String serviceId = "nacos-restful-provider";

    @GetMapping("consumer")
    public String consumer(){
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/nacos/provider",String.class)+"consumer...";
    }
}
