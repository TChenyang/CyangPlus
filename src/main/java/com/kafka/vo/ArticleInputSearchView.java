package com.kafka.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: ArticleInputSearchView
 * @PACKAGE_NAME: com.kafka.vo
 * @version: v1.0.0
 * @date: 2019/5/25 0025 14:17
 */
@Getter
@Setter
public class ArticleInputSearchView {
    private String id;
    private String title;
    private String url;
    private String author;
    private List<String> tags;
    private Long visitCount;
    private Date startTime;
    private Date endTime;

}
