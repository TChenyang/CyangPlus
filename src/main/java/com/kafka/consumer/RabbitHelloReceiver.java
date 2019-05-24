package com.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Administrator
 * @Title: RabbitHelloReceiver
 * @ProjectName CyKafkaLearning
 * @Description: TODO
 * @date 2019/5/22 002217:24
 */
@Component
@RabbitListener(queues = "hello")
public class RabbitHelloReceiver {

    Logger log = LoggerFactory.getLogger(RabbitHandler.class);

    @RabbitHandler
    public void process(String hello){
        log.info("Receiver接收时间"+new Date());
        log.info("Receiver接收内容"+hello);
    }

}
