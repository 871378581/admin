package com.segama.ege.admin.controller;

import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.WxUser;
import com.segama.ege.entity.WxUserExample;
import com.segama.ege.repository.WxUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author hxj
 * @version 1.0
 * @Description wx user相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/wx_user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class WxUserAdminController {
    @Resource
    private WxUserMapper wxUserMapper;

    private static Logger LOG = LoggerFactory.getLogger(WxUserAdminController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("nick_name") String nick_name,
            @RequestParam("phone") String phone,
            @RequestParam("userName") String userName,
            @RequestParam("account") String account,
            @RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            WxUserExample wxUserExample = new WxUserExample();
            WxUserExample.Criteria wxUserExampleCriteria = wxUserExample.createCriteria();

            wxUserExample.setPageCount(pageSize);
            wxUserExample.setPageIndex(pageIndex);
            if(!StringUtils.isEmpty(nick_name)){
                wxUserExampleCriteria.andNick_nameLike("%"+nick_name+"%");
            }
            if(!StringUtils.isEmpty(phone)){
                wxUserExampleCriteria.andPhoneLike("%"+phone+"%");
            }
            if(!StringUtils.isEmpty(userName)){
                wxUserExampleCriteria.andUser_nameLike("%"+userName+"%");
            }
            if(!StringUtils.isEmpty(account)){
                wxUserExampleCriteria.andAccountLike("%"+account+"%");
            }
            int count = wxUserMapper.countByExample(wxUserExample);
            wxUserExample.setOrderByClause("gmt_create desc");
            List<WxUser> wxUsers = wxUserMapper.selectByExample(wxUserExample);
            baseVO.setData(wxUsers);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("WxUserController#list error",e);
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
            wxUserMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                       @RequestParam("editAccount") String editAccount,
                       @RequestParam("account") String account,
                       @RequestParam("user_id") String user_id,
                       @RequestParam("nick_name") String nick_name,
                     //  @RequestParam("user_head") String user_head,
                       @RequestParam("user_name") String user_name,
                       @RequestParam("birth") String birth,
                       @RequestParam("sex") String sex,
                       @RequestParam("id_card") String id_card,
                       @RequestParam("has_bind_phone") Boolean has_bind_phone,
                       @RequestParam("phone") String phone,
                       @RequestParam("place_city") String place_city,
                       @RequestParam("last_longitude") BigDecimal last_longitude,
                       @RequestParam("last_latitude") BigDecimal last_latitude,
                       @RequestParam("membership_level") String membership_level,
                       @RequestParam("job") String job,
                       @RequestParam("user_type") Integer user_type,
                       @RequestParam("default_plate") String default_plate,
                       @RequestParam("default_car_tye") String default_car_tye,
                       @RequestParam("has_default_car") Boolean has_default_car
                               ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            WxUser wxUser = wxUserMapper.selectByPrimaryKey(id);
            if(!StringUtils.isEmpty(account)){
                wxUser.setAccount(account);
            }
            if(!StringUtils.isEmpty(user_id)){
                wxUser.setUser_id(user_id);
            }
            if(!StringUtils.isEmpty(nick_name)){
                wxUser.setNick_name(nick_name);
            }
            /*if(!StringUtils.isEmpty(user_head)){
                wxUser.setUser_head(user_head);
            }*/
            if(!StringUtils.isEmpty(user_name)){
                wxUser.setUser_name(user_name);
            }
            if(user_type != null){
                wxUser.setUser_type(user_type);
            }
            if(!StringUtils.isEmpty(birth)){
                wxUser.setBirth(birth);
            }
            if(!StringUtils.isEmpty(sex)){
                wxUser.setSex(sex);
            }
            if(!StringUtils.isEmpty(id_card)){
                wxUser.setId_card(id_card);
            }
            if(!StringUtils.isEmpty(has_bind_phone)){
                wxUser.setHas_bind_phone(has_bind_phone);
            }

            if(!StringUtils.isEmpty(phone)){
                wxUser.setPhone(phone);
            }

            if(!StringUtils.isEmpty(place_city)){
                wxUser.setPlace_city(place_city);
            }

            if(!StringUtils.isEmpty(last_longitude)){
                wxUser.setLast_longitude(last_longitude);
            }
            if(!StringUtils.isEmpty(last_latitude)){
                wxUser.setLast_latitude(last_latitude);
            }
            if(!StringUtils.isEmpty(membership_level)){
                wxUser.setMembership_level(membership_level);
            }
            if(!StringUtils.isEmpty(job)){
                wxUser.setJob(job);
            }
            if(!StringUtils.isEmpty(default_plate)){
                wxUser.setDefault_plate(default_plate);
            }
            if(!StringUtils.isEmpty(default_car_tye)){
                wxUser.setDefault_car_tye(default_car_tye);
            }
            if(!StringUtils.isEmpty(has_default_car)){
                wxUser.setHas_default_car(has_default_car);
            }
            wxUser.setGmt_modify(new Date());
            wxUser.setModifier_account(editAccount);
            wxUserMapper.updateByPrimaryKey(wxUser);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("WxUserController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
                      @RequestParam("editAccount") String editAccount,
                      @RequestParam("account") String account,
                      @RequestParam("user_id") String user_id,
                      @RequestParam("nick_name") String nick_name,
                      @RequestParam("user_head") String user_head,
                      @RequestParam("user_name") String user_name,
                      @RequestParam("birth") String birth,
                      @RequestParam("sex") String sex,
                      @RequestParam("id_card") String id_card,
                      @RequestParam("has_bind_phone") Boolean has_bind_phone,
                      @RequestParam("phone") String phone,
                      @RequestParam("place_city") String place_city,
                      @RequestParam("last_longitude") BigDecimal last_longitude,
                      @RequestParam("last_latitude") BigDecimal last_latitude,
                      @RequestParam("membership_level") String membership_level,
                      @RequestParam("job") String job,
                      @RequestParam("default_plate") String default_plate,
                      @RequestParam("default_car_tye") String default_car_tye,
                      @RequestParam("has_default_car") Boolean has_default_car
    ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(editAccount)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            WxUser wxUser = new WxUser();
            if(!StringUtils.isEmpty(account)){
                wxUser.setAccount(account);
            }
            if(!StringUtils.isEmpty(user_id)){
                wxUser.setUser_id(user_id);
            }
            if(!StringUtils.isEmpty(nick_name)){
                wxUser.setNick_name(nick_name);
            }
            if(!StringUtils.isEmpty(user_head)){
                wxUser.setUser_head(user_head);
            }
            if(!StringUtils.isEmpty(user_name)){
                wxUser.setUser_name(user_name);
            }
            if(!StringUtils.isEmpty(birth)){
                wxUser.setBirth(birth);
            }
            if(!StringUtils.isEmpty(sex)){
                wxUser.setSex(sex);
            }
            if(!StringUtils.isEmpty(id_card)){
                wxUser.setId_card(id_card);
            }
            if(!StringUtils.isEmpty(has_bind_phone)){
                wxUser.setHas_bind_phone(has_bind_phone);
            }

            if(!StringUtils.isEmpty(phone)){
                wxUser.setPhone(phone);
            }

            if(!StringUtils.isEmpty(place_city)){
                wxUser.setPlace_city(place_city);
            }

            if(!StringUtils.isEmpty(last_longitude)){
                wxUser.setLast_longitude(last_longitude);
            }
            if(!StringUtils.isEmpty(last_latitude)){
                wxUser.setLast_latitude(last_latitude);
            }
            if(!StringUtils.isEmpty(membership_level)){
                wxUser.setMembership_level(membership_level);
            }
            if(!StringUtils.isEmpty(job)){
                wxUser.setJob(job);
            }
            if(!StringUtils.isEmpty(default_plate)){
                wxUser.setDefault_plate(default_plate);
            }
            if(!StringUtils.isEmpty(default_car_tye)){
                wxUser.setDefault_car_tye(default_car_tye);
            }
            if(!StringUtils.isEmpty(has_default_car)){
                wxUser.setHas_default_car(has_default_car);
            }

            wxUser.setCreator_account(editAccount);
            wxUser.setModifier_account(editAccount);
            wxUser.setGmt_create(new Date());
            wxUser.setGmt_modify(new Date());
            wxUserMapper.insert(wxUser);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("WxUserController#add error",e);
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
                WxUser wxUser = wxUserMapper.selectByPrimaryKey(id);
                baseVO.setData(wxUser);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("WxUserController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
