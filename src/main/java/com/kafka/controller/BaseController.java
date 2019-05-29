package com.kafka.controller;

import com.kafka.vo.base.Result;
import com.kafka.vo.base.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: BaseController
 * @PACKAGE_NAME: com.kafka.controller
 * @version: v1.0.0
 * @date: 2019/5/25 0025 18:21
 */
public class BaseController {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    static final Logger log = LoggerFactory.getLogger(BaseController.class);

    /**
     * 成功时返回
     *
     * @param data
     * @param <T>
     * @return
     */
    public <T> Result<T> JsonSuccess(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.code);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        result.setData(data);
        return result;
    }

    /**
     * 失败时返回
     *
     * @param message
     * @param <T>
     * @return
     */
    public <T> Result<T> JsonError(String message) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.FAIL.code);
        result.setMessage(message);
        result.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return result;
    }
}
