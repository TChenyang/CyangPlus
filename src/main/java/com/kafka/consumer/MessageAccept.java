//package com.kafka.consumer;
//
//import jdk.nashorn.internal.runtime.options.Option;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.annotation.KafkaListeners;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
///**
// * @author Administrator
// * @Title: MessageAccept
// * @ProjectName CyKafkaLearning
// * @Description: TODO
// * @date 2019/4/4 000415:42
// */
//@Component
//@Slf4j
//public class MessageAccept {
//    /*@KafkaListener(topics = {"Tcyang"})
//    public void listen(ConsumerRecord<?,?> record){
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()){
//            Object message = kafkaMessage.get();
//            System.out.print("----------record="+record);
//            System.out.print("----------message="+message);
//        }
//    }*/
//    @KafkaListener(topics = {"user-log"})
//    public void listen(ConsumerRecord<?,?> consumerRecord, @Header(KafkaHeaders.RECEIVED_TOPIC) String  topic){
//        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
//        log.info(">>>>>>>> record = " + kafkaMessage);
//        if(kafkaMessage.isPresent()){
//            Object object = kafkaMessage.get();
//            log.info(("------------------ 消费消息 ----------------message =topic：" + topic+ ", " + object));
//        }
//    }
//}
