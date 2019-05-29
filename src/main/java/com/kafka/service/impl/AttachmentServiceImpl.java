package com.kafka.service.impl;

import com.kafka.service.AttachmentService;
import com.kafka.vo.base.AttachmentVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: AttachmentServiceImpl
 * @PACKAGE_NAME: com.kafka.service.impl
 * @version: v1.0.0
 * @date: 2019/5/28 0028 15:19
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Override
    public List<AttachmentVo> uploadFile(List<MultipartFile> files, String filePath) {
        List<AttachmentVo> attachmentVoList = new ArrayList<>();//mine
        //List<AttachmentVo> attachmentVoList = new ArrayList<>(); //原
        AttachmentVo attachmentVo = new AttachmentVo();//mine
        if(files.size() == 0){
            //AttachmentVo attachmentVo = new AttachmentVo();//before
            attachmentVo.setUploadMessage("文件为空");
            attachmentVoList.add(attachmentVo);
            return  attachmentVoList;
        }else if(StringUtils.isEmpty(filePath)) {
            attachmentVo.setUploadMessage("文件存储路径为空");
            return attachmentVoList;
        }//检查是否存在目录
        File destination = new File(filePath);
        if(!destination.exists()){
            destination.mkdir();
        }
        //uploadData
        for(int i = 0 ; i < files.size(); i++){
            //uuid file name
            String  uuid = UUID.randomUUID().toString()
                    .replace("-","");
            String orginalName = files.get(i).getOriginalFilename();
            String suffixName = orginalName.substring(orginalName.lastIndexOf("."));
            attachmentVo.setFileName(uuid+suffixName); // new fileName
            attachmentVo.setFilePath(filePath+uuid+suffixName);//文件路径
            attachmentVo.setOrginalName(orginalName);//文件原名
            //save file
            MultipartFile file = null;
            BufferedOutputStream stream = null;
            file = files.get(i);
            String realFilePath = filePath;
            if(!file.isEmpty()){
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(realFilePath + uuid +suffixName)));//set file path and name
                    stream.write(bytes);
                    stream.close();
                    //生成缩略图
                    /*if(ImageUtils.isImage(ImageUtils.getFileExtention(originalName))){
                        String[] filePaths = new String[]{realFilePath + uuid + suffixName};
                        ImageUtils.generateThumbnail2Directory(realFilePath, filePaths);
                    }*/
                    attachmentVo.setFileSize(file.getSize()/1024);
                    attachmentVo.setBooleanUpload(true);
                    attachmentVoList.add(attachmentVo);
                }catch (Exception e){
                    attachmentVo.setBooleanUpload(false);
                }
            }else{
                attachmentVo.setBooleanUpload(false);
            }
        }
        return attachmentVoList;
    }

    @Override
    public boolean downloadFile(HttpServletResponse response, String filePath, String orginalName) {
        File file = new File(filePath);
        if(file.exists()){
            byte[] buffer = new byte[1024];
            FileInputStream fileInputStream = null;
            BufferedInputStream bufferedInputStream = null;
            try {
                response.setContentType("application/force-download");
                response.setHeader("Content-Disposition", "attachment; filename="
                            + java.net.URLEncoder.encode(orginalName,"UTF-8"));
                fileInputStream = new FileInputStream(file);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                OutputStream outputStream = response.getOutputStream();
                int i = bufferedInputStream.read(buffer);
                while (i != -1){
                    outputStream.write(buffer,0,i);
                    outputStream.flush();
                    i = bufferedInputStream.read(buffer);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(bufferedInputStream != null){
                    try {
                        bufferedInputStream.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if (fileInputStream != null){
                    try{
                        fileInputStream.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean downloadFile(HttpServletResponse response, String filePath, String fileName, String orginName) {
        if(StringUtils.isEmpty(orginName)){
            orginName = fileName;
        }
        File file = new File(filePath,fileName);
        if (file.exists()){
            byte[] buffer = new byte[1024];
            FileInputStream fileInputStream = null;
            BufferedInputStream bufferedInputStream = null;
            OutputStream outputStream = null;
            try {
                response.setContentType("application/force-download");//定义输出类型
                response.setDateHeader("Content-Disposition", Long.parseLong("attachment; filename="
                        + java.net.URLEncoder.encode
                        (orginName,"UTF-8")));//设置输出文件头
                fileInputStream = new FileInputStream(file);
                //输入流 => 本地文件路径
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                //输出流
                outputStream = response.getOutputStream();
                //输出文件
                int bytes = 0;
                byte[] bufferOut = new byte[1024];
                while ((bytes = bufferedInputStream.read(bufferOut)) != -1){
                    outputStream.write(bufferOut,0,bytes);
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                if(bufferedInputStream != null){
                    try {
                        bufferedInputStream.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                if(fileInputStream != null){
                    try {
                        fileInputStream.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return true;
    }


}
