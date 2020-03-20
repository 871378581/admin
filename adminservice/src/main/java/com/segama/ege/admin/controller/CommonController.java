package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.service.FileSerivce;
import com.segama.ege.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author hxj
 * @version 1.0
 * @Description 省市区配置相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/common")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CommonController {

    @Autowired
    FileSerivce fileSerivce;

    @RequestMapping("/upload")
    public BaseVO uploadFile(@RequestParam("file") MultipartFile file) {
        InputStream inputStream = null;
        BaseVO baseVO = new BaseVO();
        try {
            inputStream = file.getInputStream();
            String url = fileSerivce.saveStreamImg(inputStream);
            baseVO.setData(url);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            CommonUtil.info("uploadFile#upload_file_failed", "exception", null, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg(e.getMessage());
            baseVO.setCode(1);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    CommonUtil.info("uploadFile#closeFile", "exception", null, e);
                }
            }
        }
        return baseVO;
    }

}
