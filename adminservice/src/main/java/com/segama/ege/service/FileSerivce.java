package com.segama.ege.service;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.UUID;

import static com.segama.ege.constant.Constants.*;

@Component
public class FileSerivce {
    @Autowired
    CacheService cacheService;

    public String saveStreamImg(InputStream inputStream) throws IOException {
        String fileName = UUID.randomUUID() + ".jpg";
        File file = new File(cacheService.get(SYSTEM_IMAGE_LOCATION), fileName);
        FileUtils.copyInputStreamToFile(inputStream, file);
        return cacheService.get(SYSTEM_CURRENT_API_HOST) + cacheService.get(SYSTEM_IMAGE_REPO_PREFIX) + fileName;
    }

    /**
     * 将链接存成二维码
     *
     * @param link 链接
     * @return 二维码图片url地址
     * @throws IOException
     */
    public String generateQRCodeImage(String link) throws IOException {
        ByteArrayOutputStream out = QRCode.from(link).to(ImageType.PNG).stream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(out.toByteArray());
        return saveStreamImg(byteArrayInputStream);
    }
}
