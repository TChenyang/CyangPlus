package com.kafka.controller;

import com.kafka.constants.FileConstants;
import com.kafka.service.AttachmentService;
import com.kafka.vo.ArticleInputSearchView;
import com.kafka.bean.Article;
import com.kafka.dao.MgArticleInfoDao;
import com.kafka.vo.base.AttachmentVo;
import com.kafka.vo.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @author: TCyang
 * @CLASS_NAME: MgArticleInfoCtrl
 * @PACKAGE_NAME: com.kafka.controller
 * @version: v1.0.0
 * @date: 2019/5/24 0024 18:56
 */
@RestController
@RequestMapping("/article")
@Api(tags = "Article_API")
public class MgArticleInfoCtrl extends BaseController{

    @Autowired
    private MgArticleInfoDao mgArticleInfoDao;

    @Autowired
    private AttachmentService attachmentService;

    @GetMapping("/insertBatch")
    @ApiOperation(value = "Article批量增加")
    public void insertBatch(){
        try {
            mgArticleInfoDao.saveBatch();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("getArticleList")
    @ApiOperation(value = "多条件文章列表查询")
    public List<Article> getArticleList(
            @RequestBody ArticleInputSearchView articleInputSearchView){
        List<Article> listArticle = null;
        try {
            listArticle = mgArticleInfoDao.getListArticle(articleInputSearchView);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  listArticle;
    }

    @ApiOperation(value = "上传文件")
    @PostMapping(value = "/uploadFile")
    @ResponseBody
    public Result<List<AttachmentVo>> uploadFile(
            HttpServletRequest request){
        List<AttachmentVo> attachmentVoList = null;
        List<MultipartFile> files = null;
        try {
            Iterator<String> iterator = ((MultipartHttpServletRequest) request).getFileNames();
            while (iterator.hasNext()) {
                files = ((MultipartHttpServletRequest) request).getFiles(iterator.next());
                if (files.size() == 0) return JsonError("文件不能为空");
            }
            String pathName = FileConstants.ARTICLE_ATTACHED_PATH;
            attachmentVoList = attachmentService.uploadFile(files, pathName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonSuccess(attachmentVoList);
    }

    @ApiOperation(value = "下载文件")
    @RequestMapping(value = "/downloadFile",method = {RequestMethod.GET,RequestMethod.POST})
    public void downloadFile(
        HttpServletResponse response,
        @RequestParam String pathName,
        @RequestParam String fileName,
        @RequestParam(required = false) String orginName){
        try {
            if (StringUtils.isEmpty(pathName) || StringUtils.isEmpty(fileName)) {
                pathName = FileConstants.ARTICLE_ATTACHED_PATH;
                attachmentService.downloadFile(response, pathName, fileName, orginName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
