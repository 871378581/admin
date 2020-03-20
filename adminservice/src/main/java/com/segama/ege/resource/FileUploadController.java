package com.segama.ege.resource;

import com.segama.ege.dto.FileUploadResult;
import com.segama.ege.service.FileSerivce;
import com.segama.ege.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/ege/api/file/")
public class FileUploadController {

    @Autowired
    FileSerivce fileSerivce;

    @PostMapping("/upload")
    public FileUploadResult uploadFile(@RequestParam("file") MultipartFile file) {
        FileUploadResult uploadResult = new FileUploadResult();
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            String url = fileSerivce.saveStreamImg(inputStream);
            uploadResult.setUrl(url);
            return uploadResult;
        } catch (Exception e) {
            CommonUtil.info("uploadFile#upload_file_failed", "exception", null, e);
            uploadResult.setSuccess(false);
            uploadResult.setErrorMessage(e.getMessage());
            uploadResult.setErrorCode("upload_file_failed");
            return uploadResult;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    CommonUtil.info("uploadFile#closeFile", "exception", null, e);
                }
            }
        }
    }
}
