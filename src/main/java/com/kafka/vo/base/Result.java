package com.kafka.vo.base;

import com.mongodb.util.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: Result
 * @PACKAGE_NAME: com.kafka.vo.base
 * @version: v1.0.0
 * @date: 2019/5/25 0025 18:25
 */
@Getter
@Setter
@ApiModel(value = "Result",description = "公共返回数据")
public class Result<T> {
    @ApiModelProperty(value = "响应码")
    private int code;

    @ApiModelProperty(value = "响应消息")
    private String message;

    @ApiModelProperty(value = "响应时间")
    private String timestamp;

    @ApiModelProperty(value = "响应内容")
    private T data;



    /*@Override
    public String toString(){
        return JSON.toJSONString(this);
    }*/
}
