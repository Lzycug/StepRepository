
package com.lzycug.consumer.service;

import com.lzycug.consumer.config.RabbitmqConfig;
import com.rabbitmq.client.Channel;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-03-27
 */
@Service
public class ConsumerService {

    // 监听email队列
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
    public void receive_email(String msg, Message message, Channel channel) {
        System.out.println("email-----" + msg);
    }

    // 监听sms队列
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_SMS})
    public void receive_sms(String msg, Message message, Channel channel) {
        System.out.println("sms-----" + msg);
    }

    // 监听log队列
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_LOG})
    public void receive_log(String msg, Message message, Channel channel) {
        System.out.println("log-----" + msg);
    }

}
