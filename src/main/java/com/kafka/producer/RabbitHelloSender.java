package com.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * @author Administrator
 * @Title: RabbitHelloSender
 * @ProjectName CyKafkaLearning
 * @Description: TODO
 * @date 2019/5/22 002217:18
 */
@Component
public class RabbitHelloSender {

    Logger log = LoggerFactory.getLogger(RabbitHelloSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(){
        String context = "hello"+new Date();
        log.info("Sender-->"+context);
        amqpTemplate.convertAndSend("hello",context);
        return "sucess";
    }
}
