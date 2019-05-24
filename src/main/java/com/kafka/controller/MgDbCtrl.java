package com.kafka.controller;

import com.kafka.bean.MongoTest;
import com.kafka.dao.MongoTestDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: MgDbCtrl
 * @PACKAGE_NAME: com.kafka.controller
 * @version: v1.0.0
 * @date: 2019/5/24 0024 13:30
 */
@RestController
public class MgDbCtrl {

    private static final Logger log = LoggerFactory.getLogger(MgDbCtrl.class);

    @Autowired
    private MongoTestDao mongoTestDao;

    @PostMapping
    public void save(int id,String name){
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @throws Exception
     */
    @GetMapping(value = "/save")
    public void saveTest() throws Exception{
        try {
            MongoTest mongoTest = new MongoTest();
//            mongoTest.setId(UUID.randomUUID().toString().replace("-","").toLowerCase());
            mongoTest.setAge("22");
            mongoTest.setName("Mr Tian");
            log.info("save ready .............. ");
            mongoTestDao.save(mongoTest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/findByName")
    public MongoTest findTestByName(@RequestParam String name){
        MongoTest mongoTest = null;
        try {
            mongoTest = mongoTestDao.findTestByName(name);
            log.info(mongoTest.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return mongoTest;
    }
}


















