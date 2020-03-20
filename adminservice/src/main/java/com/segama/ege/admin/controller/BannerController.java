package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.Banner;
import com.segama.ege.entity.BannerExample;
import com.segama.ege.repository.BannerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author hxj
 * @version 1.0
 * @Description banner相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/banner")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BannerController {
    @Resource
    private BannerMapper bannerMapper;

    private static Logger LOG = LoggerFactory.getLogger(BannerController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            BannerExample bannerExample = new BannerExample();
            BannerExample.Criteria bannerExampleCriteria = bannerExample.createCriteria();
            int count = bannerMapper.countByExample(bannerExample);
            bannerExample.setPageCount(pageSize);
            bannerExample.setPageIndex(pageIndex);
            bannerExample.setOrderByClause("gmt_create desc");
            List<Banner> banners = bannerMapper.selectByExample(bannerExample);
            baseVO.setData(banners);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("BannerController#list error",e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("id") Long id ) {
        BaseVO baseVO = new BaseVO();
        if(id == null){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("id为空不能删除！");
        }else {
            bannerMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("account") String account,
                    @RequestParam("photo_url") String photo_url,
                    @RequestParam("url") String url,
                    @RequestParam("sort") Long sort,
                    @RequestParam("is_disable") Boolean is_disable
                               ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null || StringUtils.isEmpty(photo_url)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            Banner banner = bannerMapper.selectByPrimaryKey(id);
            if(sort!=null){
                banner.setSort(sort);
            }
            if(is_disable!=null){
                banner.setIs_disable(is_disable);
            }
            if(!StringUtils.isEmpty(url)){
                banner.setUrl(url);
            }
            if(!StringUtils.isEmpty(photo_url)){
                banner.setPhoto_url(photo_url);
            }
            banner.setGmt_modify(new Date());
            banner.setModifier_account(account);
            bannerMapper.updateByPrimaryKey(banner);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("BannerController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
                      @RequestParam("account") String account,
                      @RequestParam("photo_url") String photo_url,
                      @RequestParam("url") String url,
                      @RequestParam("sort") Long sort,
                      @RequestParam("is_disable") Boolean is_disable
    ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(photo_url)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            Banner banner = new Banner();
            if(sort!=null){
                banner.setSort(sort);
            }
            if(is_disable!=null){
                banner.setIs_disable(is_disable);
            }
            if(!StringUtils.isEmpty(url)){
                banner.setUrl(url);
            }
            if(!StringUtils.isEmpty(photo_url)){
                banner.setPhoto_url(photo_url);
            }

            banner.setCreator_account(account);
            banner.setModifier_account(account);
            banner.setGmt_create(new Date());
            banner.setGmt_modify(new Date());
            bannerMapper.insert(banner);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("BannerController#add error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id == null){
                baseVO.setErrorMsg("id为不能为空！");
                baseVO.setSuccess(false);
            }else {
                Banner banner = bannerMapper.selectByPrimaryKey(id);
                baseVO.setData(banner);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("BannerController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
