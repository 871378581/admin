package com.segama.ege.admin.controller;

import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.Car;
import com.segama.ege.entity.CarExample;
import com.segama.ege.repository.CarMapper;
import com.segama.ege.util.PlateConvertUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
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
 * @Description 汽车管理相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/car_manage")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CarController {
    @Resource
    private CarMapper carMapper;

    private static Logger LOG = LoggerFactory.getLogger(CarController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("vin") String vin,
            @RequestParam("car_type_name") String car_type_name,
            @RequestParam("plate") String plate
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            CarExample carExample = new CarExample();
            CarExample.Criteria carExampleCriteria = carExample.createCriteria();
            if (StringUtils.isNotEmpty(vin)) {
                carExampleCriteria.andVinLike("%" + vin + "%");
            }
            if (StringUtils.isNotEmpty(car_type_name)) {
                carExampleCriteria.andCar_type_nameLike("%" + car_type_name + "%");
            }
            if (StringUtils.isNotEmpty(plate)) {
                carExampleCriteria.andPlateLike("%" + plate + "%");
            }
            int count = carMapper.countByExample(carExample);
            carExample.setPageCount(pageSize);
            carExample.setPageIndex(pageIndex);
            carExample.setOrderByClause("gmt_create desc");
            List<Car> cars = carMapper.selectByExample(carExample);
            baseVO.setData(cars);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("CarController#list error", e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("id") Long id) {
        BaseVO baseVO = new BaseVO();
        if (id == null) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("id为空不能删除！");
        } else {
            carMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                      // @RequestParam("user_id") String user_id,
                       @RequestParam("plate") String plate,
                     //  @RequestParam("car_type_id") Long car_type_id,
                      // @RequestParam("car_type_name") String car_type_name,
                       @RequestParam("car_type_color") String car_type_color,
                       @RequestParam("car_logo_url") String car_logo_url,
                       @RequestParam("gmt_last_maintenance") String gmt_last_maintenance,
                       @RequestParam("membership_card_id") String membership_card_id,
                       @RequestParam("car_status") String car_status,
                       @RequestParam("gmt_activate") String gmt_activate,
                       @RequestParam("gmt_take_effect") String gmt_take_effect,
                       @RequestParam("gmt_lose_effect") String gmt_lose_effect,
                       @RequestParam("is_default") Boolean is_default,
                       @RequestParam("color") String color,
                       @RequestParam("vin") String vin,
                       @RequestParam("card_level") String card_level,
                       @RequestParam("account") String account
    ) {
        BaseVO baseVO = new BaseVO();
        try {

            if (id==null || StringUtils.isEmpty(account)) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            Car car = carMapper.selectByPrimaryKey(id);
            //car.setUser_id(user_id);
            if(!StringUtils.isEmpty(plate)) {
                car.setPlate(PlateConvertUtil.convertToCapital(plate));
            }
            /*if(car_type_id!=null) {
                car.setCar_type_id(car_type_id);
            }

            if(car_type_id!=null) {
                String car_type_name = car_type_id.toString();
                if(!CollectionUtils.isEmpty(carTypeLists)){
                    for (Map<String, Object> carTypeList : carTypeLists) {
                        if(car_type_id.equals((Long)carTypeList.get("value"))){
                            car_type_name = (String)carTypeList.get("label");
                            break;
                        }
                    }
                }
                car.setCar_type_name(car_type_name);
            }*/
            if(!StringUtils.isEmpty(car_type_color)) {
                car.setCar_type_color(car_type_color);
            }

            if(!StringUtils.isEmpty(card_level)) {
                car.setCard_level(card_level);
            }

            if(is_default!=null){
                car.setIs_default(is_default);
            }
            if(!StringUtils.isEmpty(car_logo_url)) {
                car.setCar_logo_url(car_logo_url);
            }
            if(!StringUtils.isEmpty(gmt_take_effect)) {
                car.setGmt_take_effect(DateUtils.parseDate(gmt_take_effect, DateUtil.YYYY_MM_DD_HH_MM_SS));
            }
            if(!StringUtils.isEmpty(gmt_lose_effect)) {
                car.setGmt_lose_effect(DateUtils.parseDate(gmt_lose_effect, DateUtil.YYYY_MM_DD_HH_MM_SS));
            }
            if(!StringUtils.isEmpty(gmt_last_maintenance)) {
                car.setGmt_last_maintenance(DateUtils.parseDate(gmt_last_maintenance, DateUtil.YYYY_MM_DD_HH_MM_SS));
            }
            if(!StringUtils.isEmpty(gmt_activate)) {
                car.setGmt_activate(DateUtils.parseDate(gmt_activate, DateUtil.YYYY_MM_DD_HH_MM_SS));
            }
            if(!StringUtils.isEmpty(membership_card_id)) {
                car.setMembership_card_id(membership_card_id);
            }
            if(!StringUtils.isEmpty(car_status)) {
                car.setCar_status(car_status);
            }

            if(!StringUtils.isEmpty(color)) {
                car.setColor(color);
            }
            if(!StringUtils.isEmpty(vin)) {
                car.setVin(vin);
            }



            car.setModifier_account(account);
            car.setGmt_modify(new Date());
            carMapper.updateByPrimaryKey(car);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("CarController#edit error", e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
            @RequestParam("id") Long id,
          //  @RequestParam("user_id") String user_id,
            @RequestParam("plate") String plate,
            @RequestParam("car_type_id") Long car_type_id,
            @RequestParam("car_type_name") String car_type_name,
            @RequestParam("car_type_color") String car_type_color,
            @RequestParam("car_logo_url") String car_logo_url,
            @RequestParam("gmt_last_maintenance") String gmt_last_maintenance,
            @RequestParam("membership_card_id") String membership_card_id,
            @RequestParam("car_status") String car_status,
            @RequestParam("gmt_activate") String gmt_activate,
            @RequestParam("gmt_take_effect") String gmt_take_effect,
            @RequestParam("gmt_lose_effect") String gmt_lose_effect,
            @RequestParam("is_default") Boolean is_default,
            @RequestParam("color") String color,
            @RequestParam("vin") String vin,
            @RequestParam("account") String account
            ) {

        BaseVO baseVO = new BaseVO();
        try {
            if (StringUtils.isEmpty(account)) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            Car car = new Car();
          //  car.setUser_id(user_id);
            if(!StringUtils.isEmpty(plate)) {
                car.setPlate(PlateConvertUtil.convertToCapital(plate));
            }
            if(car_type_id!=null) {
                car.setCar_type_id(car_type_id);
            }

            if(!StringUtils.isEmpty(car_type_name)) {
                car.setCar_type_name(car_type_name);
            }
            if(!StringUtils.isEmpty(car_type_color)) {
                car.setCar_type_color(car_type_color);
            }

            if(is_default!=null){
                car.setIs_default(is_default);
            }
            if(!StringUtils.isEmpty(car_logo_url)) {
                car.setCar_logo_url(car_logo_url);
            }
            if(!StringUtils.isEmpty(gmt_take_effect)) {
                car.setGmt_take_effect(DateUtils.parseDate(gmt_take_effect, DateUtil.YYYY_MM_DD_HH_MM_SS));
            }
            if(!StringUtils.isEmpty(gmt_lose_effect)) {
                car.setGmt_lose_effect(DateUtils.parseDate(gmt_lose_effect, DateUtil.YYYY_MM_DD_HH_MM_SS));
            }
            if(!StringUtils.isEmpty(gmt_last_maintenance)) {
                car.setGmt_last_maintenance(DateUtils.parseDate(gmt_last_maintenance, DateUtil.YYYY_MM_DD_HH_MM_SS));
            }
            if(!StringUtils.isEmpty(gmt_activate)) {
                car.setGmt_activate(DateUtils.parseDate(gmt_activate, DateUtil.YYYY_MM_DD_HH_MM_SS));
            }
            if(!StringUtils.isEmpty(membership_card_id)) {
                car.setMembership_card_id(membership_card_id);
            }
            if(!StringUtils.isEmpty(car_status)) {
                car.setCar_status(car_status);
            }

            if(!StringUtils.isEmpty(color)) {
                car.setColor(color);
            }
            if(!StringUtils.isEmpty(vin)) {
                car.setVin(vin);
            }

            car.setModifier_account(account);
            car.setCreator_account(account);
            car.setGmt_create(new Date());
            car.setGmt_modify(new Date());
            car.setVersion(0);
            carMapper.insert(car);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("CarController#add error", e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id) {
        BaseVO baseVO = new BaseVO();
        try {
            if (id == null) {
                baseVO.setErrorMsg("id为不能为空！");
                baseVO.setSuccess(false);
            } else {
                Car car = carMapper.selectByPrimaryKey(id);
                baseVO.setData(car);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("CarController#get Exception input param is id:" + id, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
