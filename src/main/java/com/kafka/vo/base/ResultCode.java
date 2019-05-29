package com.kafka.vo.base;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: ResultCode
 * @PACKAGE_NAME: com.kafka.vo.base
 * @version: v1.0.0
 * @date: 2019/5/25 0025 18:33
 */
public enum ResultCode {
    SUCCESS(200), //成功
    FAIL(400), //失败
    UNAUTHORIZED(401), //未签证
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500); //服务器内部错误

    public int code;

    ResultCode(int code){
        this.code = code;
    }
}
