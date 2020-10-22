package com.lzycug.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description：
 * author：lzyCug
 * date: 2020/10/22 11:19
 */
@RestController
@RequestMapping("/nacos")
public class ProviderController {
    @GetMapping("provider")
    public String provider() {
        return "provider invoke|NO.1";
    }
}
