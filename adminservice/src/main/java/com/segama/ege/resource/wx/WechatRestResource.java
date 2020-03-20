package com.segama.ege.resource.wx;

import com.segama.ege.dto.wx.ShareConfiguration;
import com.segama.ege.dto.wx.WxJsShareRequest;
import com.segama.ege.service.WeChatService;
import com.segama.ege.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ege/api/wechat/")
public class WechatRestResource {
    @Autowired
    WeChatService weChatService;

    @PostMapping("/js/share/post")
    public ShareConfiguration jsShareTicket(@RequestBody WxJsShareRequest wxJsShareRequest) {
        ShareConfiguration shareJsConfig = weChatService.getShareJsConfig(wxJsShareRequest.getUrl());
        CommonUtil.info("jsShareTicket", "result", new Object[]{wxJsShareRequest.getUrl()}, shareJsConfig);
        return shareJsConfig;
    }
}
