package com.kafka.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;

import java.util.List;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: PageViewModel
 * @PACKAGE_NAME: com.kafka.vo.base
 * @version: v1.0.0
 * @date: 2019/5/25 0025 18:50
 */
@Getter
@Setter
@ApiModel(value = "PageViewModel",description = "data result")
public class PageViewModel<T> {
    @ApiModelProperty(value = "当前页",required = true)
    int pageIndex;

    @ApiModelProperty(value = "每页条数",required = true)
    int pageSize;

    @ApiModelProperty(value = "总个数",required = true)
    long totalCount;

    List<T> data;
}
