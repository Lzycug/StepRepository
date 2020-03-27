
package com.lzycug.producer.service;

import com.lzycug.producer.config.RabbitmqConfig;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-03-27
 */
@Service
public class ProducerService {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(String message) {
        for (int i = 0; i < 5; i++) {
            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPICS_INFORM, "inform.sms.email",
                message + "   No." + i);
            System.out.println("Send Message is:" + message + "   No." + i);
        }
    }
}
