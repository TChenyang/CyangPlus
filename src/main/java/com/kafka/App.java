package com.kafka;

import com.kafka.bean.Message;
import com.kafka.producer.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App{
    @Autowired
    private MessageSender messageSender;

    private  static final Logger logger = LoggerFactory.getLogger(App.class);
    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            //调用消息发送类中的消息发送方法
            messageSender.send(String.valueOf(i));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
