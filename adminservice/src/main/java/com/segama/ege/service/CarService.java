package com.segama.ege.service;

import com.segama.ege.domain.CarStatus;
import com.segama.ege.dto.CarInfoResponseListDTO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.CarMapper;
import com.segama.ege.repository.CarTypeMapper;
import com.segama.ege.repository.WxUserMapper;
import com.segama.ege.util.PageCountUtil;
import com.segama.ege.util.PlateConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

import static com.segama.ege.constant.Constants.CACHE_OBJECT_KEY_CAR_TYPE;
import static com.segama.ege.constant.Constants.SYSTEM_CURRENT_API_HOST;

@Component
public class CarService {

    @Resource
    private CarTypeMapper carTypeMapper;

    @Autowired
    CacheService cacheService;

    @Resource
    private WxUserMapper wxUserMapper;


    @Resource
    private CarMapper carMapper;

    public List<CarType> loadAllCardType() {
        List<CarType> carTypes;
        if (cacheService.containsCacheObjec(CACHE_OBJECT_KEY_CAR_TYPE)) {
            carTypes = (List<CarType>) cacheService.getCacheObject(CACHE_OBJECT_KEY_CAR_TYPE);
        } else {
            carTypes = new ArrayList<>();
            CarTypeExample example = new CarTypeExample();
            example.setOrderByClause("brand_first_letter asc, brand asc, car_type asc");
            int totalCnt = carTypeMapper.countByExample(example);
            int pageSize = 4000;
            int iterTimes = (totalCnt / pageSize) + 1;
            for (int i = 0; i < iterTimes; i++) {
                example.setPageCount(pageSize);
                example.setPageIndex(i + 1);
                List<CarType> list = carTypeMapper.selectByExample(example);
                if (!CollectionUtils.isEmpty(list)) {
                    carTypes.addAll(list);
                }
            }

            fillLogoImg(carTypes);
            if (!CollectionUtils.isEmpty(carTypes)) {
                cacheService.putCacheObject(CACHE_OBJECT_KEY_CAR_TYPE, carTypes);
            }
        }

        return carTypes;
    }

    /**
     * 填充车辆图标信息
     *
     * @param carTypes
     */
    private void fillLogoImg(List<CarType> carTypes) {
        if (CollectionUtils.isEmpty(carTypes)) {
            return;
        }

        for (CarType carType : carTypes) {
            String url = String.format("%s/adminservice/demo/car/%s.png", cacheService.get(SYSTEM_CURRENT_API_HOST), carType.getBrand_code());
            carType.setLogo_url(url);
        }
    }

    public static void main(String[] args) {
        System.out.println(1 / 200);
        System.out.println(200 / 200);
        System.out.println(201 / 200);
        System.out.println(401 / 200);
    }

    /**
     * 设置为默认车辆
     *
     * @param newCar
     */
    public void markCardAsDefault( WxUser wxUser, Car newCar, boolean is_default_car) {
        if(is_default_car){
            /**
             * 把其他车辆都设置为非默认
             */
            CarExample carExample = new CarExample();
            carExample.createCriteria().andUser_idEqualTo(newCar.getUser_id());
            List<Car> cars = carMapper.selectByExample(carExample);
            Date now = new Date();
            for (Car car : cars) {
                if (car.getPlate().equalsIgnoreCase(newCar.getPlate())) {
                    continue;
                }
                car.setIs_default(false);
                car.setPlate(PlateConvertUtil.convertToCapital(car.getPlate()));
                car.setGmt_modify(now);
                this.carMapper.updateByPrimaryKeySelective(car);
            }

            //更新个人信息上的默认车辆 车牌 以及会员等级
            wxUser.setGmt_modify(new Date());
            wxUser.setDefault_car_tye(newCar.getCar_type_name());
            wxUser.setDefault_plate(PlateConvertUtil.convertToCapital(newCar.getPlate()));
            wxUser.setCard_level(newCar.getCard_level());
            wxUser.setHas_default_car(true);
            wxUserMapper.updateByPrimaryKeySelective(wxUser);
        }else{
            if(wxUser.getHas_default_car() && !StringUtils.isEmpty(wxUser.getDefault_plate())
                    && wxUser.getDefault_plate().equalsIgnoreCase(newCar.getPlate())){
                updateWxUserNoDefaultCar(wxUser);;
            }else if (wxUser.getHas_default_car() && !StringUtils.isEmpty(wxUser.getDefault_plate())
                    && !wxUser.getDefault_plate().equalsIgnoreCase(newCar.getPlate())){
                CarExample carExample2 = new CarExample();
                carExample2.createCriteria().andPlateEqualTo(wxUser.getDefault_plate());
                List<Car> oldCars = this.carMapper.selectByExample(carExample2);
                if(CollectionUtils.isEmpty(oldCars)){
                    //说明是修改原有id对应的车记录，且修改车牌号码，同时确定标志了非默认车辆
                    updateWxUserNoDefaultCar(wxUser);
                }
            }
        }
    }

    private void updateWxUserNoDefaultCar(WxUser wxUser){
        wxUser.setGmt_modify(new Date());
        wxUser.setDefault_car_tye("");
        wxUser.setDefault_plate("");
        wxUser.setCard_level("");
        wxUser.setHas_default_car(false);
        wxUserMapper.updateByPrimaryKeySelective(wxUser);
    }

    public CarInfoResponseListDTO getCarsListInfo(WxUser currentLoginUser, int currentPage, int showCount, String carStatus){
        CarInfoResponseListDTO listDTO = new CarInfoResponseListDTO();
        try {
            CarExample example = new CarExample();
            example.setOrderByClause("is_default desc, gmt_create desc");
            CarExample.Criteria c = example.createCriteria();
            c.andUser_idEqualTo(currentLoginUser.getUser_id());
            if(carStatus != null && !StringUtils.isEmpty(carStatus)){
                c.andCar_statusEqualTo(carStatus);
            }

            int totalRecord = carMapper.countByExample(example);
            int totalPage = PageCountUtil.computeTotalPageByCount(totalRecord, showCount);
            listDTO.addPageInfo(totalPage, currentPage);

            example.setPageIndex(currentPage);
            example.setPageCount(showCount);
            List<Car> cars = carMapper.selectByExample(example);
            listDTO.addCars(cars, currentLoginUser);
        } catch (Exception e) {
            throw e;
        }
        return listDTO;
    }
}
