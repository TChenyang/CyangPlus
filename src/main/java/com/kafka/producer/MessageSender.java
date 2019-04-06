package com.kafka.producer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kafka.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author Administrator
 * @Title: MessageSender
 * @ProjectName CyKafkaLearning
 * @Description: TODO
 * @date 2019/4/4 000415:34
 */
@Component
public class MessageSender {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    private Gson gson = new GsonBuilder().create();

    //send msg way
    public void send(String userid){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        /*System.out.print(gson.toJson(message));*/
        System.out.print("发送用户日志数据:"+message);
        kafkaTemplate.send("user-log",gson.toJson(message));
    }
}
