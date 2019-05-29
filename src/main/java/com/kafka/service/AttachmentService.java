package com.kafka.service;

import com.kafka.vo.base.AttachmentVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: AttachmentService
 * @PACKAGE_NAME: com.kafka.service
 * @version: v1.0.0
 * @date: 2019/5/28 0028 15:19
 */
public interface AttachmentService {
    /**
     * @param files
     * @param filePath
     * @return
     */
    List<AttachmentVo> uploadFile(List<MultipartFile> files,String filePath);

    /**
     * @param response
     * @param filePath
     * @param orginalName
     * @return
     */
    boolean downloadFile(HttpServletResponse response,String filePath,String orginalName);

    boolean downloadFile(HttpServletResponse response,String filePath,String fileName,String orginName);
}
