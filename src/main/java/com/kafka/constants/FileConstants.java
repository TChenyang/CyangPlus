package com.kafka.constants;

import java.io.File;

/**
 * @Description:文件常量
 * @author: TCyang
 * @CLASS_NAME: FileConstants
 * @PACKAGE_NAME: com.kafka.constants
 * @version: v1.0.0
 * @date: 2019/5/28 0028 14:33
 */
public class FileConstants {
    public static String commonPath =
            System.getProperty("user.dir")+ File.separator+"upload-dir";
    //文件名
    public static final String FILE_UUID_SPLIT="-";
    public static final String FILE_REPLACE = "";
    public static final String FILE_SPLIT = ".";

    //文章模块文件存放路径
    public static final String ARTICLE_PHOTO_PATH = commonPath + File
            .separator + "articlePhoto" + File
            .separator; //图片存放路径
    public static final String ARTICLE_ATTACHED_PATH = commonPath + File
            .separator + "articleAttached" + File
            .separator; //附件存放路径





}
