package com.kafka.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: MongoTest
 * @PACKAGE_NAME: com.kafka.bean
 * @version: v1.0.0
 * @date: 2019/5/24 0024 16:22
 */
@Getter
@Setter
@Document(collection = "mongotest")
public class MongoTest {
    private String id;
    private String age;
    private String name;
}
















