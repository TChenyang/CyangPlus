package com.kafka.dao;

import com.kafka.bean.MongoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: MongoTestDao
 * @PACKAGE_NAME: com.kafka.dao
 * @version: v1.0.0
 * @date: 2019/5/24 0024 16:29
 */
@Repository
public class MongoTestDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     */
    @Transactional
    public void save(MongoTest mongoTest){
        mongoTemplate.save(mongoTest);
    }

    /**
     *根据用户名查询对象
     */
    public MongoTest findTestByName(String name){
        Query query = new Query(Criteria.where("name").is(name));
        MongoTest mgt = mongoTemplate.findOne(query,MongoTest.class);
        return mgt;
    }

    /**
     * 更新对象
     * @param mongoTest
     */
    public void updateTest(MongoTest mongoTest){
        Query query = new Query(Criteria.where("id").is(mongoTest.getId()));
        Update update = new Update()
                        .set("age",mongoTest.getAge())
                        .set("name",mongoTest.getName());
        //更新查询返回结果集第一条
        mongoTemplate.updateFirst(query,update,MongoTest.class);
    }

    /**
     * 删除操作
     * @param id
     */
    public void delTestById(Integer id){
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,MongoTest.class);
    }


}













