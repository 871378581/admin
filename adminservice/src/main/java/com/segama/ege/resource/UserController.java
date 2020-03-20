package com.segama.ege.resource;

import com.alibaba.fastjson.JSON;
import com.segama.ege.dto.BaseResult;
import com.segama.ege.dto.Greeting;
import com.segama.ege.entity.WxUser;
import com.segama.ege.service.CarService;
import com.segama.ege.service.FileSerivce;
import com.segama.ege.service.UserService;
import com.segama.ege.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * hello-world sample
 * https://spring.io/guides
 */
@RestController
@RequestMapping("/ege/api/test")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CarService carService;

    @Autowired
    FileSerivce fileSerivce;

    private static String lastUpdate;

    @RequestMapping("/preload")
    public BaseResult preload() {
        lastUpdate = new Date().toString();
        BaseResult done = BaseResult.success(lastUpdate);
        //初始化车型数据
        carService.loadAllCardType();

        return done;
    }

    public static void main(String[] args) {
        System.out.println(new Date().toString());
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = new Greeting();
        //int count = userService.countByName(name);
        greeting.setName("test");
        return greeting;
    }


    @RequestMapping("/qrcode")
    public Greeting qrCode(@RequestParam(value = "url") String url) throws IOException {
        Greeting greeting = new Greeting();
        String link = fileSerivce.generateQRCodeImage(url);
        greeting.setName(link);
        return greeting;
    }

    @RequestMapping("/cookieTest")
    public Greeting cookie(@CookieValue(value = "session", defaultValue = "none") String cookie) {
        Greeting greeting = new Greeting();
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        greeting.setName(JSON.toJSONString(currentLoginUser));
        return greeting;
    }


    @PostMapping("/file/upload/json")
    public Greeting handleFileUploadReturnResult(@RequestParam("file") MultipartFile file) {
        Greeting greeting = new Greeting();
        greeting.setName(file.getOriginalFilename());
        return greeting;
    }

    /*@PostMapping("/test")
    public void test() {
        //this.userService.test();
    }*/
}
