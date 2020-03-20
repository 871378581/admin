package com.segama.ege.resource;

import com.segama.ege.dto.BaseResult;
import com.segama.ege.dto.ReportDTO;
import com.segama.ege.dto.ReportRequestDTO;
import com.segama.ege.entity.WxUser;
import com.segama.ege.service.WxTestItemService;
import com.segama.ege.util.CommonUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ege/api/testItem")
public class WxTestItemController {

    @Resource
    WxTestItemService wxTestItemService;

    @PostMapping("/getTestItem")
    public BaseResult getTestItem(@RequestBody ReportRequestDTO reportRequestDTO) {
        BaseResult result;
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        try {
            ReportDTO testItem = wxTestItemService.getTestItem(currentLoginUser, reportRequestDTO);
            result = BaseResult.success(testItem);
        } catch (Exception e) {
            result = BaseResult.error("500", "获取检测项失败!");
        }
        return result;
    }

    @PostMapping("/submitTestItem")
    public BaseResult submitTestItem(@RequestBody ReportRequestDTO dto) {
        BaseResult result;
        try {
            WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
            wxTestItemService.submitTestItem(currentLoginUser, dto);
            result = BaseResult.success("ok");
        } catch (Exception e) {
            result = BaseResult.error("500", "提交检测项失败!");
        }
        return result;
    }

    /*@PostMapping("/editTestItem")
    public BaseResult editTestItem(@RequestBody ReportRequestDTO dto) {
        BaseResult result;
        try {
            WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
            wxTestItemService.editTestItem(currentLoginUser, dto);
            result = BaseResult.success("ok");
        } catch (Exception e) {
            result = BaseResult.error("500", "编辑检测项失败!");
        }
        return result;
    }*/
}
