package com.segama.ege.admin.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hxj
 * @version 1.0
 * @Description 测试相关的接口
 * @date 2020-03-07 14:33
 */
@RestController
@RequestMapping("/ege/api/test")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CheckPreloadController {
    
    @RequestMapping("/preload")
    public String preload() {
        return "ok";
    }
}
