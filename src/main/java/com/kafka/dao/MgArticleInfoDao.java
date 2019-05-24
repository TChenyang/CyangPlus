package com.kafka.dao;

import com.kafka.bean.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: MgArticleInfoDao
 * @PACKAGE_NAME: com.kafka.dao
 * @version: v1.0.0
 * @date: 2019/5/24 0024 18:57
 */
@Repository
public class MgArticleInfoDao {
    private static final Logger log = LoggerFactory.getLogger(MgArticleInfoDao.class);
    @Autowired
    private  MongoTemplate mongoTemplate;

    public void saveBatch(){
        List<Article> articleList = new ArrayList<>();
        for(int i = 0;i<100;i++){
            Article article = new Article();
            article.setTitle("MongoTemplate的基本使用");
            article.setAuthor("yinjihuan");
            article.setUrl("http://cxytiandi.com/blog/detail/" + i);
            article.setTags(Arrays.asList("java", "mongodb", "spring"));
            article.setVisitCount(0L);
            article.setAddTime(new Date());
            log.info(article.toString());
            articleList.add(article);
        }
        mongoTemplate.insert(articleList,Article.class);
    }

}
