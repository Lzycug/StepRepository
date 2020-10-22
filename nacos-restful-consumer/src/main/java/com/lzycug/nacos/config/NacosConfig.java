package com.lzycug.nacos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * description：
 * author：lzyCug
 * date: 2020/10/22 11:23
 */
@Configuration
public class NacosConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
