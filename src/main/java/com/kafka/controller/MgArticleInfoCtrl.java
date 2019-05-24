package com.kafka.controller;

import com.kafka.dao.MgArticleInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: MgArticleInfoCtrl
 * @PACKAGE_NAME: com.kafka.controller
 * @version: v1.0.0
 * @date: 2019/5/24 0024 18:56
 */
@RestController
public class MgArticleInfoCtrl {
    @Autowired
    private MgArticleInfoDao mgArticleInfoDao;

    @GetMapping("/insertBatch")
    public void insertBatch(){
        try {
            mgArticleInfoDao.saveBatch();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
