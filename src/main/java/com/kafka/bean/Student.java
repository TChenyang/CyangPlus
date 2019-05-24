package com.kafka.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: Student
 * @PACKAGE_NAME: com.kafka.bean
 * @version: v1.0.0
 * @date: 2019/5/24 0024 16:01
 */
@Getter
@Setter
@Document(collection = "student")
public class Student {
    private String studentId;
    private String name;
    private int age;
    private String sex;
}
