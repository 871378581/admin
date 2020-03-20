package com.segama.ege.resource;

import com.segama.ege.domain.CarStatus;
import com.segama.ege.domain.MembershipLevel;
import com.segama.ege.dto.*;
import com.segama.ege.entity.*;
import com.segama.ege.repository.CarMapper;
import com.segama.ege.repository.WxUserMapper;
import com.segama.ege.service.CacheService;
import com.segama.ege.service.CarService;
import com.segama.ege.util.CommonUtil;
import com.segama.ege.util.PlateConvertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.DefaultValue;
import java.util.*;

import static com.segama.ege.constant.Constants.SYSTEM_CURRENT_API_HOST;

@RestController
@RequestMapping("/ege/api/car")
public class WxCarController extends BaseController {

    @Resource
    private CarMapper carMapper;

    @Resource
    private WxUserMapper userMapper;

    @Autowired
    CarService carService;

    @Autowired
    CacheService cacheService;

    @RequestMapping("/getCarsInfo")
    public BaseResult getCarsInfo(@RequestParam(value = "user_id", defaultValue = "") String user_id,
                                  @DefaultValue("1") @RequestParam("currentPage") int currentPage,
                                  @DefaultValue("10") @RequestParam("showCount") int showCount) {
        BaseResult result;
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            return BaseResult.buildLoginRequiredResponse();
        }

        try {
            CarInfoResponseListDTO listDTO = carService.getCarsListInfo(currentLoginUser,
                    currentPage, showCount, null);
            result = BaseResult.success(listDTO);
        } catch (Exception e) {
            result = BaseResult.error("500", "获取用户的车辆失败!" + e.getMessage());
        }
        return result;
    }

    @RequestMapping("/getOrderCarsInfo")
    public BaseResult getOrderCarsInfo(@RequestParam(value = "user_id", defaultValue = "") String user_id,
                                  @DefaultValue("1") @RequestParam("currentPage") int currentPage,
                                  @DefaultValue("10") @RequestParam("showCount") int showCount) {
        BaseResult result;
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            WxUserExample wxUserExample = new WxUserExample();
            wxUserExample.createCriteria().andUser_idEqualTo(user_id);
            List<WxUser> users = this.userMapper.selectByExample(wxUserExample);
            if(CollectionUtils.isEmpty(users)){
                return BaseResult.buildLoginRequiredResponse();
            }
            currentLoginUser = users.get(0);
        }

        try {
            CarInfoResponseListDTO listDTO = carService.getCarsListInfo(currentLoginUser, currentPage,
                    showCount, CarStatus.using.getCode());
            result = BaseResult.success(listDTO);
        } catch (Exception e) {
            result = BaseResult.error("500", "获取用户的车辆失败!" + e.getMessage());
        }
        return result;
    }

    @RequestMapping("/getCarsInfoByPlate")
    public BaseResult getCarsInfoByPlate(@RequestParam(value = "user_id", defaultValue = "") String user_id,
                                         @RequestParam(value = "id") Long car_id) {
        BaseResult result = null;

        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            return BaseResult.buildLoginRequiredResponse();
        }
        Car car = this.carMapper.selectByPrimaryKey(car_id);
        if(car == null){
            result = BaseResult.error("500", "用户识别失败!");
        }

        car.setPlate(PlateConvertUtil.convertToCapital(car.getPlate()));
        result = BaseResult.success(car);
        return result;
    }

    /**
     * 车型检索
     *
     * @param brand_name
     * @return
     */
    @RequestMapping("/getCarTypeInfo")
    public BaseResult getCarTypeInfo(@RequestParam(value = "keyword", defaultValue = "") String brand_name) {
        BaseResult result;

        CarTypeInfoListDTO listDTO = new CarTypeInfoListDTO();

        List<CarType> carTypes = carService.loadAllCardType();

        if (!CollectionUtils.isEmpty(carTypes)) {
            Map<String, List<EachCarTypeInfo>> infoMap = new HashMap<String, List<EachCarTypeInfo>>();
            for (CarType carType : carTypes) {
                if (StringUtils.isEmpty(carType.getBrand_first_letter())) {
                    continue;
                }
                if (StringUtils.isBlank(carType.getBrand())) {
                    continue;
                }
                /**
                 * 过滤检索
                 */
                if (StringUtils.isNoneBlank(brand_name)) {
                    if (!carType.getBrand().contains(brand_name)) {
                        continue;
                    }
                }

                if (infoMap.containsKey(carType.getBrand_first_letter())) {
                    List<EachCarTypeInfo> values = infoMap.get(carType.getBrand_first_letter());
                    int j = 0;
                    for (; j < values.size(); ++j) {
                        EachCarTypeInfo eachCarTypeInfo = values.get(j);
                        if (eachCarTypeInfo.getName().equals(carType.getBrand())) {
                            eachCarTypeInfo.addChild(carType.getCar_type());
                            values.set(j, eachCarTypeInfo);
                            infoMap.put(carType.getBrand_first_letter(), values);
                            break;
                        }
                    }
                    if (j == values.size()) {
                        EachCarTypeInfo myInfo = new EachCarTypeInfo();
                        myInfo.setBrandImg(carType.getLogo_url());
                        myInfo.setName(carType.getBrand());
                        myInfo.addChild(carType.getCar_type());
                        myInfo.addChild(carType.getCar_type(), carType.getCar_type_code());
                        myInfo.setBrand_code(carType.getBrand_code());
                        values.add(myInfo);
                        infoMap.put(carType.getBrand_first_letter(), values);
                    }
                } else {
                    EachCarTypeInfo myInfo = new EachCarTypeInfo();
                    myInfo.setBrandImg(carType.getLogo_url());
                    myInfo.setName(carType.getBrand());
                    myInfo.addChild(carType.getCar_type());
                    myInfo.addChild(carType.getCar_type(), carType.getCar_type_code());
                    myInfo.setBrand_code(carType.getBrand_code());
                    List<EachCarTypeInfo> myInfos = new ArrayList<EachCarTypeInfo>();
                    myInfos.add(myInfo);
                    infoMap.put(carType.getBrand_first_letter(), myInfos);
                }
            }
            for (String myLetter : infoMap.keySet()) {
                CarTypeInfoDTO carTypeInfoDTO = new CarTypeInfoDTO();
                carTypeInfoDTO.setBrand_first_letter(myLetter);
                carTypeInfoDTO.setChildren(infoMap.get(myLetter));
                listDTO.addCarTypeInfoDTO(carTypeInfoDTO);
            }
        }
        listDTO.sortAscByBrandFirstLetter();
        result = BaseResult.success(listDTO);
        return result;
    }

    @PostMapping("/saveCarInfo")
    public BaseResult saveCarInfo(@RequestBody CarInfoRequestDTO dto) {
        BaseResult result = new BaseResult();
        try{
            CommonUtil.info("saveCarInfo#CarInfoRequestDTO", "parameters", null, dto);
            WxUser wxUser = CommonUtil.getCurrentLoginUser();
            if (wxUser == null) {
                return BaseResult.buildLoginRequiredResponse();
            }
            if (dto.getId() <= 0) {
                //表示新增
                if (StringUtils.isNotEmpty(dto.getUser_id()) && StringUtils.isNotEmpty(dto.getPlate())) {
                    CarExample example = new CarExample();

                    List<String> plates = new ArrayList<String>();
                    plates.add(dto.getPlate());
                    plates.add(PlateConvertUtil.convertToCapital(dto.getPlate()));

                    example.createCriteria().andPlateIn(plates);
                    List<Car> cars = carMapper.selectByExample(example);
                    if (!CollectionUtils.isEmpty(cars)) {
                        Car oldCar = cars.get(0);
                        if (!oldCar.getUser_id().equals(dto.getUser_id())) {
                            result.setSuccess(false);
                            result.setErrorCode("503");
                            result.setErrorMessage("该车牌(忽略大小写)" + dto.getPlate() + "已经绑定其他微信用户！");
                            return result;
                        } else {
                            result.setSuccess(false);
                            result.setErrorCode("503");
                            result.setErrorMessage("该微信用户已经绑定了本车辆，车牌(忽略大小写)=" + dto.getPlate());
                            return result;
                        }
                    } else {
                        Car newCar = new Car();
                        newCar.setUser_id(dto.getUser_id());
                        newCar.setPlate(PlateConvertUtil.convertToCapital(dto.getPlate()));
                        newCar.setColor(dto.getColor());
                        newCar.setVin(dto.getVin());
                        newCar.setCar_type_name(dto.getType());
                        newCar.setCar_brand_code(dto.getBrand_code());
                        newCar.setCar_type_code(dto.getType_code());
                        newCar.setCar_type_image(renderCarTypeUrl(dto.getBrand_code(), dto.getType_code()));
                        if (StringUtils.isNoneBlank(dto.getCar_logo_url())) {
                            newCar.setCar_logo_url(dto.getCar_logo_url());
                        }
                        newCar.setGmt_create(new Date());
                        newCar.setVersion(0);
                        newCar.setCar_status(CarStatus.not_activated.getCode());
                        boolean isDefault = false;
                        if(dto.getIs_default() != null){
                            isDefault = dto.getIs_default();
                        }
                        newCar.setIs_default(isDefault);
                        newCar.setCard_level(MembershipLevel.common_card.getCode());
                        int ret = carMapper.insertSelective(newCar);
                        carService.markCardAsDefault(wxUser, newCar, isDefault);
                        checkSetDefaultCar(wxUser);
                        result = BaseResult.success("success");
                    }
                } else {
                    result.setSuccess(false);
                    result.setErrorCode("503");
                    result.setErrorMessage("微信用户user_id或车牌号码plate为空，无法新增车辆。user_id=" + dto.getUser_id()
                            + ", plate=" + dto.getPlate());
                    return result;
                }
            } else {
                //id>0, 编辑车辆信息
                Car oldCar = this.carMapper.selectByPrimaryKey(dto.getId());
                if (oldCar == null) {
                    result.setSuccess(false);
                    result.setErrorCode("503");
                    result.setErrorMessage("原车辆记录不存在，无法更新。id=" + dto.getId());
                    return result;
                }
                //判断是否仅仅编辑默认车辆
                oldCar.setPlate(PlateConvertUtil.convertToCapital(oldCar.getPlate()));
                boolean only_change_default_car = false;
                if(dto.getPlate().equalsIgnoreCase(oldCar.getPlate())
                        && dto.getColor().equals(oldCar.getColor())
                        &&dto.getType().equals(oldCar.getCar_type_name())){
                    only_change_default_car = true;
                }
                if (!only_change_default_car && !CarStatus.parse(oldCar.getCar_status()).isAllowEdit()) {
                    result.setErrorCode("504");
                    result.setErrorMessage("车辆已激活使用中，不允许修改编辑车辆");
                    return result;
                }
                oldCar.setVersion(oldCar.getVersion() + 1);
                oldCar.setColor(dto.getColor());
                oldCar.setVin(dto.getVin());
                oldCar.setCar_brand_code(dto.getBrand_code());
                oldCar.setCar_type_code(dto.getType_code());
                oldCar.setCar_type_image(renderCarTypeUrl(dto.getBrand_code(), dto.getType_code()));
                oldCar.setPlate(PlateConvertUtil.convertToCapital(dto.getPlate()));
                oldCar.setCar_type_name(dto.getType());
                if (StringUtils.isNoneBlank(dto.getCar_logo_url())) {
                    oldCar.setCar_logo_url(dto.getCar_logo_url());
                }
                boolean isDefault = false;
                if(dto.getIs_default() != null){
                    isDefault = dto.getIs_default();
                }
                oldCar.setIs_default(isDefault);
                oldCar.setGmt_modify(new Date());
                carMapper.updateByPrimaryKeySelective(oldCar);
                carService.markCardAsDefault(wxUser, oldCar, isDefault);
                result = BaseResult.success("success");
            }
        }catch (Exception e){
            CommonUtil.info("saveCarInfo#CarInfoRequestDTO", "exception", null, e);
        }
        return result;
    }

    private String renderCarTypeUrl(String brand_code, String type_code) {
        return String.format("%s/egecarservice/demo/car/type/car.png", cacheService.get(SYSTEM_CURRENT_API_HOST));
//        return String.format("%s/egecarservice/demo/car/type/%s/%s.png", cacheService.get(SYSTEM_CURRENT_API_HOST), brand_code, type_code);
    }

    @PostMapping("/deleteCarById")
    public BaseResult deleteCarById(@RequestBody DeleteCarRequestDTO dto) {
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            return BaseResult.buildLoginRequiredResponse();
        }
        BaseResult result = null;

        if (dto.getId() > 0 && dto.getUser_id().equals(currentLoginUser.getUser_id())) {
            Car myCar = this.carMapper.selectByPrimaryKey(dto.getId());
            if(myCar == null){
                result = BaseResult.error("500", "车辆不存在，id=" + dto.getId());
                return result;
            }

            if (!CarStatus.parse(myCar.getCar_status()).isAllowEdit()) {
                result = BaseResult.error("504", "车辆已激活使用中，不允许删除车辆" );
                return result;
            }

            int ret = this.carMapper.deleteByPrimaryKey(dto.getId());
            if (ret > 0) {
                if(currentLoginUser.getHas_default_car() &&
                        currentLoginUser.getDefault_plate().equalsIgnoreCase(myCar.getPlate())){
                    currentLoginUser.setHas_default_car(false);
                    currentLoginUser.setDefault_plate("");
                    currentLoginUser.setDefault_car_tye("");
                    currentLoginUser.setCard_level(MembershipLevel.common_card.getCode());
                    currentLoginUser.setGmt_modify(new Date());
                    this.userMapper.updateByPrimaryKeySelective(currentLoginUser);
                }
                checkSetDefaultCar(currentLoginUser);
                result = BaseResult.success("success");
                return result;
            }
        }
        result = BaseResult.error();
        return result;
    }

    @PostMapping("/setDefaultCar")
    public BaseResult checkSetDefaultCar(@RequestBody SetDefaultCarRequestDTO dto) {
        BaseResult result = null;
        WxUser wxUser = CommonUtil.getCurrentLoginUser();
        if (wxUser == null) {
            return BaseResult.buildLoginRequiredResponse();
        }

        if (StringUtils.isNotEmpty(dto.getUser_id()) && dto.getId() > 0) {
            Car car = carMapper.selectByPrimaryKey(dto.getId());
            if (car == null || !car.getUser_id().equals(dto.getUser_id())) {
                result = BaseResult.error("500", "车不是当前用户所有，无法设置为默认车辆。");
            }
            boolean isDefault = false;
            if(dto.getIs_default() != null){
                isDefault = dto.getIs_default();
            }
            setDefaultCar(car, wxUser, isDefault);
            result = BaseResult.success("success");
        }else{
            result = BaseResult.error();
        }
        return result;
    }

    private void checkSetDefaultCar(WxUser wxUser){
        CarExample carExample = new CarExample();
        carExample.createCriteria().andUser_idEqualTo(wxUser.getUser_id());
        List<Car> carList = this.carMapper.selectByExample(carExample);
        if(!CollectionUtils.isEmpty(carList) && (carList.size() == 1)){
            Car oneCar = carList.get(0);
            setDefaultCar(oneCar, wxUser, true);
        }
    }
    private void setDefaultCar(Car car, WxUser wxUser, boolean isDefault){
        car.setIs_default(isDefault);
        car.setGmt_modify(new Date());
        carMapper.updateByPrimaryKeySelective(car);
        carService.markCardAsDefault(wxUser, car, isDefault);
    }
}
