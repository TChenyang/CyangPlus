package com.kafka.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: Article
 * @PACKAGE_NAME: com.kafka.bean
 * @version: v1.0.0
 * @date: 2019/5/24 0024 18:53
 */
@Getter
@Setter
@Document(collection = "article_info")
public class Article {
    @Id
    private String id;
    @Field("title")
    private String title;
    @Field("url")
    private String url;
    @Field("author")
    private String author;
    @Field("tags")
    private List<String> tags;
    @Field("visit_count")
    private Long visitCount;
    @Field("add_time")
    private Date addTime;
}
