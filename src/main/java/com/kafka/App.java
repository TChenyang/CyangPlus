package com.kafka;

//import com.kafka.bean.Message;
//import com.kafka.producer.MessageSender;
import com.kafka.producer.RabbitHelloSender;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableSwagger2
public class App{
//    @Autowired
//    private MessageSender messageSender;

//      @Autowired
//      private RabbitHelloSender rabbitHelloSender;


    private  static final Logger logger = LoggerFactory.getLogger(App.class);
  /*  @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            //调用消息发送类中的消息发送方法
            messageSender.send(String.valueOf(i));
        }
    }*/

    /*@PostConstruct
    public void oneToOne() throws Exception{
        rabbitHelloSender.send();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
