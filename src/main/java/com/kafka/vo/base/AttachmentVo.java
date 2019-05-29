package com.kafka.vo.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description:附件信息Vo
 * @author: TCyang
 * @CLASS_NAME: AttachmentVo
 * @PACKAGE_NAME: com.kafka.vo.base
 * @version: v1.0.0
 * @date: 2019/5/28 0028 14:48
 */
@Getter
@Setter
public class AttachmentVo {
    private String fileName;

    /*文件实际路径*/
    private String filePath;

    /*文件实际名称*/
    private String orginalName;

    /*文件是否上传成功*/
    private boolean booleanUpload;

    /*文件上传返回信息 是否上传成功，错误信息等*/
    private String uploadMessage;

    /*上传类型*/
    private String businessType;

    /*文件大小*/
    private Long fileSize;
}
