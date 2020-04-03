
package com.lzycug.producer.controller;

import com.lzycug.producer.service.ProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-03-27
 */
@RestController
@RequestMapping("/mq")
public class ProducerController {
    @Autowired
    ProducerService producerService;

    @PostMapping("send")
    public String send(String message) {
        producerService.send(message);
        return "OK";
    }

    @PostMapping("sendLog")
    public String sendLog(@RequestBody byte[] bytes) {
        producerService.sendLog(bytes);
        return "OK";
    }
}
