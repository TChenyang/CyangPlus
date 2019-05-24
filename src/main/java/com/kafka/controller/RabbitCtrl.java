package com.kafka.controller;

import com.kafka.producer.RabbitHelloSender;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @Title: RabbitCtrl
 * @ProjectName CyKafkaLearning
 * @Description: TODO
 * @date 2019/5/22 002218:12
 */
@RestController
public class RabbitCtrl {
    @Autowired
    private RabbitHelloSender rabbitHelloSender;
    

    @ApiOperation(value = "通过消费者发送下次,生产者接收消息")
    @GetMapping("hello")
    public String helloTest(){
        rabbitHelloSender.send();
        return "success";
    }

}
