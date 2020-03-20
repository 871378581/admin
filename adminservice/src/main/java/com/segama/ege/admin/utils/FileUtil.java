package com.segama.ege.admin.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.UUID;

public class FileUtil {
    private static final String DEFAULT_IMG_FILE_EXT = "jpg"; //默认图片扩展名
    private static final String IMG_LOCAL_STORE = "/root/imgstore/oss"; //默认图片扩展名
    //TODO
    private static final String IMG_URL_PREFIX = "http://yohotest.jinlingongyi.cn/oss/"; //默认图片扩展名

    public static String saveBase64Img(String base64) throws IOException {
        return saveBase64Img(base64, DEFAULT_IMG_FILE_EXT);
    }

    /**
     * 将base64的文件存成本地服务器文件
     *
     * @param base64
     * @param fileExt
     * @return 返回图片的url地址
     * @throws IOException
     */
    public static String saveBase64Img(String base64, String fileExt) throws IOException {
        if (StringUtils.isBlank(base64)) return null;
        if (StringUtils.isBlank(fileExt)) fileExt = DEFAULT_IMG_FILE_EXT;

        String[] imgPart = base64.split(",");
        byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(imgPart[1]);

        String fileName = UUID.randomUUID() + "." + fileExt;
        File localImgStore = new File(IMG_LOCAL_STORE, fileName);
        FileUtils.copyInputStreamToFile(new ByteArrayInputStream(imageBytes), localImgStore);
        return IMG_URL_PREFIX + fileName;
    }

    /**
     * 把文件留存成服务器文件
     *
     * @param stream
     * @param fileExt
     * @return
     * @throws IOException
     */
    public static String saveStream(InputStream stream, String fileExt) throws IOException {
        String fileName = UUID.randomUUID() + "." + fileExt;
        File localImgStore = new File(IMG_LOCAL_STORE, fileName);

        FileUtils.copyInputStreamToFile(stream, localImgStore);
        return IMG_URL_PREFIX + fileName;
    }

    public static String saveStream(InputStream stream) {
        try {
            return saveStream(stream, DEFAULT_IMG_FILE_EXT);
        } catch (IOException e) {
            throw new RuntimeException("保存文件失败", e);
        }
    }

    public static String saveStreamImg(InputStream inputStream, String fileName) throws IOException {
        File file = new File(IMG_LOCAL_STORE, fileName);
        FileUtils.copyInputStreamToFile(inputStream, file);
        return IMG_URL_PREFIX + fileName;
    }

    public static String saveStreamImg(InputStream inputStream) throws IOException {
        String fileName = UUID.randomUUID().toString() + "." + DEFAULT_IMG_FILE_EXT;
        return saveStreamImg(inputStream, fileName);
    }

    /**
     * 从url上download文件到服务器
     *
     * @param url
     * @param ext
     * @return
     * @throws IOException
     */
    public static String download(String url, String ext) throws IOException {
        String fileName = UUID.randomUUID() + "." + ext;
        File localImgStore = new File(IMG_LOCAL_STORE, fileName);
        FileUtils.copyURLToFile(new URL(url), localImgStore);
        return IMG_URL_PREFIX + fileName;
    }
}
