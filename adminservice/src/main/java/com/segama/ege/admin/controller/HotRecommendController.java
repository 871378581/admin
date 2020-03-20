package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.HotRecommend;
import com.segama.ege.entity.HotRecommendExample;
import com.segama.ege.repository.HotRecommendMapper;
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
 * @Description 热门推荐相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/hot_recommend")
@CrossOrigin(origins = "*", maxAge = 3600)
public class HotRecommendController {
    @Resource
    private HotRecommendMapper hotRecommendMapper;

    private static Logger LOG = LoggerFactory.getLogger(HotRecommendController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            HotRecommendExample hotRecommendExample = new HotRecommendExample();
            HotRecommendExample.Criteria hotRecommendExampleCriteria = hotRecommendExample.createCriteria();
            int count = hotRecommendMapper.countByExample(hotRecommendExample);
            hotRecommendExample.setPageCount(pageSize);
            hotRecommendExample.setPageIndex(pageIndex);
            hotRecommendExample.setOrderByClause("gmt_create desc");
            List<HotRecommend> hotRecommends = hotRecommendMapper.selectByExample(hotRecommendExample);
            baseVO.setData(hotRecommends);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("HotRecommendController#list error",e);
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
            hotRecommendMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                    @RequestParam("account") String account,
                    @RequestParam("photo_url") String photo_url,
                    @RequestParam("url") String url,
                    @RequestParam("description") String description,
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
            HotRecommend hotRecommend = hotRecommendMapper.selectByPrimaryKey(id);
            if(sort!=null){
                hotRecommend.setSort(sort);
            }
            if(is_disable!=null){
                hotRecommend.setIs_disable(is_disable);
            }
            if(!StringUtils.isEmpty(description)){
                hotRecommend.setDescription(description);
            }
            if(!StringUtils.isEmpty(url)){
                hotRecommend.setUrl(url);
            }
            if(!StringUtils.isEmpty(photo_url)){
                hotRecommend.setPhoto_url(photo_url);
            }
            hotRecommend.setGmt_modify(new Date());
            hotRecommend.setModifier_account(account);
            hotRecommendMapper.updateByPrimaryKey(hotRecommend);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("HotRecommendController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
                      @RequestParam("account") String account,
                      @RequestParam("photo_url") String photo_url,
                      @RequestParam("url") String url,
                      @RequestParam("description") String description,
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
            HotRecommend hotRecommend = new HotRecommend();
            if(sort!=null){
                hotRecommend.setSort(sort);
            }
            if(is_disable!=null){
                hotRecommend.setIs_disable(is_disable);
            }
            if(!StringUtils.isEmpty(url)){
                hotRecommend.setUrl(url);
            }
            if(!StringUtils.isEmpty(description)){
                hotRecommend.setDescription(description);
            }
            if(!StringUtils.isEmpty(photo_url)){
                hotRecommend.setPhoto_url(photo_url);
            }
            
            hotRecommend.setCreator_account(account);
            hotRecommend.setModifier_account(account);
            hotRecommend.setGmt_create(new Date());
            hotRecommend.setGmt_modify(new Date());
            hotRecommendMapper.insert(hotRecommend);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("HotRecommendController#add error",e);
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
                HotRecommend hotRecommend = hotRecommendMapper.selectByPrimaryKey(id);
                baseVO.setData(hotRecommend);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("HotRecommendController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
