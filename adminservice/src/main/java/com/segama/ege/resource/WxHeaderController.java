package com.segama.ege.resource;

import com.segama.ege.constant.Constants;
import com.segama.ege.domain.AreaTypeEnum;
import com.segama.ege.domain.BusinessCooperateApplyStatus;
import com.segama.ege.domain.ComplaintSuggestStatus;
import com.segama.ege.dto.*;
import com.segama.ege.entity.*;
import com.segama.ege.repository.*;
import com.segama.ege.service.CacheService;
import com.segama.ege.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/ege/api/header")
public class WxHeaderController {
    @Resource
    private BannerMapper bannerMapper;

    @Resource
    private HotRecommendMapper hotRecommendMapper;

    @Resource
    private BusinessCooperateApplyMapper businessCooperateApplyMapper;

    @Resource
    private ComplaintSuggestMapper complaintSuggestMapper;

    @Autowired
    CacheService cacheService;

    @Resource
    private ProvCityAreaMapper provCityAreaMapper;


    @PostMapping("/commitComplaintSuggest")
    public BaseResult commitComplaintSuggest(@RequestBody ComplaintSuggestRequestDTO dto) {
        BaseResult result = null;
        WxUser wxUser = CommonUtil.getCurrentLoginUser();
        if (wxUser == null) {
            return BaseResult.buildLoginRequiredResponse();
        }
        if (dto.getUser_id().equals(wxUser.getUser_id()) && !StringUtils.isEmpty(dto.getContent())) {
            ComplaintSuggest suggest = new ComplaintSuggest();
            suggest.setUser_name(wxUser.getNick_name());
            suggest.setUser_id(dto.getUser_id());
            suggest.setSuggest_desc(dto.getContent());
            suggest.setStatus(ComplaintSuggestStatus.not_read.getCode());
            suggest.setPhone(wxUser.getPhone());
            Date now = new Date();
            suggest.setGmt_create(now);
            complaintSuggestMapper.insert(suggest);
            result = BaseResult.success("success");
        } else {
            result = BaseResult.error("500", "投诉建议不能为空");
        }
        return result;
    }

    @PostMapping("/commitBusinessCooperate")
    public BaseResult commitBusinessCooperate(@RequestBody BusinessCooperateApplyRequestDTO dto) {
        BaseResult result = null;
        WxUser wxUser = CommonUtil.getCurrentLoginUser();
        if (wxUser == null) {
            return BaseResult.buildLoginRequiredResponse();
        }
        if (dto.getUser_id().equals(wxUser.getUser_id()) && !StringUtils.isEmpty(dto.getName())) {
            BusinessCooperateApply apply = new BusinessCooperateApply();
            apply.setPhone_num(dto.getPhone());
            apply.setUser_name(dto.getName());
            apply.setShop_name(dto.getShop_name());
            apply.setShop_area_size(dto.getShop_area_size());
            apply.setShop_address(dto.getShop_address());
            if ("1".equals(dto.getMerchant_type())) {
                apply.setMerchant_type("1"); //门店
            } else {
                apply.setMerchant_type("2");//渠道
            }

            apply.setShop_address(dto.getShop_address());
//            apply.setProject_description(dto.getCooperate_type_description());
//            apply.setExpect_contact_time(dto.getExpect_contact_time());
            apply.setUser_id(dto.getUser_id());
            apply.setContacter_status(BusinessCooperateApplyStatus.not_read.getCode());
            Date now = new Date();
            apply.setGmt_create(now);
            businessCooperateApplyMapper.insert(apply);
            result = BaseResult.success("success");
        } else {
            result = BaseResult.error("500", "姓名不能为空");
        }
        return result;
    }

    @RequestMapping("/getBannerList")
    public BaseResult getBannerList() {
        BaseResult result = null;
        BannerInfoListDTO dto = new BannerInfoListDTO();
        BannerExample example = new BannerExample();
        example.setOrderByClause("sort asc");
        example.createCriteria().andIs_disableEqualTo(false);
        List<Banner> banners = bannerMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(banners)) {
            for (int i = 0; i < banners.size(); ++i) {
                Banner banner = banners.get(i);
                EachBannerInfo eachBannerInfo = new EachBannerInfo();
                eachBannerInfo.setId(banner.getId());
                eachBannerInfo.setPhoto_url(banner.getPhoto_url());
                eachBannerInfo.setSort_order(banner.getSort());
                eachBannerInfo.setUrl(banner.getUrl());
                dto.addBannerInfo(eachBannerInfo);
            }
            result = BaseResult.success(dto);
        } else {
            result = BaseResult.error("501", "无横幅列表!");
        }
        return result;
    }

    @RequestMapping("/getContactInfo")
    public BaseResult getContactInfo() {
        ContactInfoResponseDTO responseDTO = new ContactInfoResponseDTO();
        responseDTO.setCustomer_service_email(cacheService.getConfig(Constants.customer_service_email));
        responseDTO.setCustomer_service_phone(cacheService.getConfig(Constants.customer_service_phone));
        responseDTO.setCustomer_service_wechat_qr_code(cacheService.getConfig(Constants.customer_service_wechat_qr_code));
        responseDTO.setDescription_words(cacheService.getConfig(Constants.description_words));
        BaseResult result = BaseResult.success(responseDTO);
        return result;
    }

    @RequestMapping("/getHotRecommendList")
    public BaseResult getHotRecommendList() {
        BaseResult result = null;
        HotRecommendInfoListDTO dto = new HotRecommendInfoListDTO();
        HotRecommendExample example = new HotRecommendExample();
        example.setOrderByClause("sort asc");
        example.createCriteria().andIs_disableEqualTo(false);
        List<HotRecommend> hotRecommends = hotRecommendMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(hotRecommends)) {
            for (int i = 0; i < hotRecommends.size(); ++i) {
                HotRecommend hotRecommend = hotRecommends.get(i);
                EachHotRecommendInfo eachHotRecommendInfo = new EachHotRecommendInfo();
                eachHotRecommendInfo.setId(hotRecommend.getId());
                eachHotRecommendInfo.setPhoto_url(hotRecommend.getPhoto_url());
                eachHotRecommendInfo.setSort_order(hotRecommend.getSort());
                eachHotRecommendInfo.setUrl(hotRecommend.getUrl());
                eachHotRecommendInfo.setDescription(hotRecommend.getDescription());
                dto.addHotRecommendInfo(eachHotRecommendInfo);
            }
            result = BaseResult.success(dto);
        } else {
            result = BaseResult.error("501", "无热门推荐列表!");
        }
        return result;
    }

    private List<ProvCityArea> getProvCityArea(String type, String code_name, String parent_code){
        ProvCityAreaExample example = new ProvCityAreaExample();
        ProvCityAreaExample.Criteria criteria = example.createCriteria();
        criteria.andIs_disableEqualTo(false);
        criteria.andTypeEqualTo(type);
        if(!StringUtils.isEmpty(code_name)){
            criteria.andCode_nameEqualTo(code_name);
        }
        if(!StringUtils.isEmpty(parent_code)){
            criteria.andParent_codeEqualTo(parent_code);
        }
        List<ProvCityArea> provinces = provCityAreaMapper.selectByExample(example);
        return provinces;
    }

    private void getProvCityAreaByKeyword(String keyword, Map<String, ProvCityArea> allAreas,
                                          List<ProvCityArea> provinces,
                                          List<ProvCityArea> cities,
                                          List<ProvCityArea> regions){
        ProvCityAreaExample example = new ProvCityAreaExample();
        ProvCityAreaExample.Criteria criteria = example.createCriteria();
        criteria.andIs_disableEqualTo(false);
        example.setOrderByClause("type asc, code asc");
        List<ProvCityArea> areas = provCityAreaMapper.selectByExample(example);
        allAreas.clear();
        provinces.clear();
        cities.clear();
        regions.clear();
        if(!CollectionUtils.isEmpty(areas)){
            for (int i = 0; i < areas.size(); ++i){
                ProvCityArea eachArea = areas.get(i);
                allAreas.put(eachArea.getCode(), eachArea);
                if((StringUtils.isEmpty(keyword))
                        || ((!StringUtils.isEmpty(keyword)) && (eachArea.getCode_name().contains(keyword)))){
                    if(eachArea.getType().equals(AreaTypeEnum.province.getCode())){
                        provinces.add(eachArea);
                    }else if(eachArea.getType().equals(AreaTypeEnum.city.getCode())){
                        cities.add(eachArea);
                    }else if (eachArea.getType().equals(AreaTypeEnum.district.getCode())){
                        regions.add(eachArea);
                    }
                }
            }
        }
    }


    private ProvinceCityInfo getProvinceCityListByRegion(Map<String, ProvCityArea> allAreas,
                                                            ProvCityArea region){
        ProvCityArea city = allAreas.get(region.getParent_code());
        ProvCityArea province = allAreas.get(city.getParent_code());

        ProvinceCityInfo myProvince = new ProvinceCityInfo();
        myProvince.setProvince(province.getCode_name());

        CityRegionInfo myCity = new CityRegionInfo();
        myCity.setCity_code(city.getCode());
        myCity.setCity(city.getCode_name());
        myCity.addRegion(region.getCode_name());

        myProvince.addCity(myCity);
        return myProvince;
    }

    private ProvinceCityInfo getProvinceCityListByCity(Map<String, ProvCityArea> allAreas,
                                                          ProvCityArea city){
        ProvCityArea province = allAreas.get(city.getParent_code());
        ProvinceCityInfo myProvince = new ProvinceCityInfo();
        myProvince.setProvince(province.getCode_name());
        myProvince.addCity(dealCity(city, ""));
        return myProvince;
    }

    private CityRegionInfo dealCity(ProvCityArea city, String region_code_name){
        CityRegionInfo myCity = new CityRegionInfo();
        myCity.setCity_code(city.getCode());
        myCity.setCity(city.getCode_name());

        List<ProvCityArea> regions = getProvCityArea(AreaTypeEnum.district.getCode(), region_code_name, city.getCode());
        if (!CollectionUtils.isEmpty(regions)) {
            for (int j = 0; j < regions.size(); ++j) {
                ProvCityArea region = regions.get(j);
                myCity.addRegion(region.getCode_name());
            }
        }
        return myCity;
    }

    private ProvinceCityInfo getProvinceCityListByProvince(Map<String, ProvCityArea> allAreas, ProvCityArea province){
        ProvinceCityInfo myProvince = new ProvinceCityInfo();
        myProvince.setProvince(province.getCode_name());

        List<ProvCityArea> cities = getProvCityArea(AreaTypeEnum.city.getCode(), "", province.getCode());
        if(!CollectionUtils.isEmpty(cities)) {
            for (int i = 0; i < cities.size(); ++i) {
                ProvCityArea city = cities.get(i);
                myProvince.addCity(dealCity(city, ""));
            }
        }
        return myProvince;
    }


    private ProvinceCityListDTO getProvinceCityList(){

        ProvinceCityListDTO dto = new ProvinceCityListDTO();

        List<ProvCityArea> provinces = getProvCityArea(AreaTypeEnum.province.getCode(), "", "");
        if(!CollectionUtils.isEmpty(provinces)){
            for(int k = 0; k < provinces.size(); ++k){
                ProvCityArea province = provinces.get(k);

                ProvinceCityInfo myProvince = new ProvinceCityInfo();
                myProvince.setProvince(province.getCode_name());

                List<ProvCityArea> cities = getProvCityArea(AreaTypeEnum.city.getCode(), "", province.getCode());
                if(!CollectionUtils.isEmpty(cities)){
                    for (int i = 0; i < cities.size(); ++i) {
                        ProvCityArea city = cities.get(i);
                        myProvince.addCity(dealCity(city, ""));
                    }
                }
                dto.addProvinceCityInfo(myProvince);
            }

        }
        return dto;
    }

    private void genenateProvinceCityListInfoByProvince(Map<String, ProvCityArea> allAreas,
                                                       List<ProvCityArea> provinces,
                                                       Map<String, ProvinceCityInfo> retDTO){
        if(!CollectionUtils.isEmpty(provinces)){
            for (int i = 0; i < provinces.size(); ++i){
                ProvCityArea eachProvince = provinces.get(i);
                ProvinceCityInfo new_province = getProvinceCityListByProvince(allAreas, eachProvince);
                updateProvince(new_province, retDTO);
            }
        }
    }

    private void genenateProvinceCityListInfoByCity(Map<String, ProvCityArea> allAreas,
                                                       List<ProvCityArea> cities,
                                                       Map<String, ProvinceCityInfo> retDTO){
        if(!CollectionUtils.isEmpty(cities)){
            for (int i = 0; i < cities.size(); ++i){
                ProvCityArea eachCity = cities.get(i);
                ProvinceCityInfo new_province = getProvinceCityListByCity(allAreas, eachCity);
                updateProvince(new_province, retDTO);
            }
        }
    }

    private void genenateProvinceCityListInfoByRegion(Map<String, ProvCityArea> allAreas,
                                                    List<ProvCityArea> regions,
                                                    Map<String, ProvinceCityInfo> retDTO){
        if(!CollectionUtils.isEmpty(regions)){
            for (int i = 0; i < regions.size(); ++i){
                ProvCityArea eachRegion = regions.get(i);
                ProvinceCityInfo new_province = getProvinceCityListByRegion(allAreas, eachRegion);
                updateProvince(new_province, retDTO);
            }
        }
    }

    private void updateProvince(ProvinceCityInfo new_province, Map<String, ProvinceCityInfo> retDTO){
        if(!retDTO.containsKey(new_province.getProvince())){
            retDTO.put(new_province.getProvince(), new_province);
        }else{
            ProvinceCityInfo old_province = retDTO.get(new_province.getProvince());
            old_province.updateProvinceCityInfo(new_province);
            retDTO.put(new_province.getProvince(), old_province);
        }
    }

    @RequestMapping("/getProvinceCityList")
    public BaseResult getProvinceCityList(@RequestParam(value = "keyword") String keyword) {
        List<ProvCityArea> provinces = new ArrayList<ProvCityArea>();
        List<ProvCityArea> cities = new ArrayList<ProvCityArea>();
        List<ProvCityArea> regions = new ArrayList<ProvCityArea>();
        Map<String, ProvCityArea> allAreas = new HashMap<String, ProvCityArea>();

        getProvCityAreaByKeyword(keyword, allAreas, provinces, cities, regions);

        Map<String, ProvinceCityInfo> retDTO = new HashMap<String, ProvinceCityInfo>();
        genenateProvinceCityListInfoByProvince(allAreas, provinces, retDTO);
        genenateProvinceCityListInfoByCity(allAreas, cities, retDTO);
        genenateProvinceCityListInfoByRegion(allAreas, regions, retDTO);

        ProvinceCityListDTO ret = new ProvinceCityListDTO();
        for (Map.Entry<String, ProvinceCityInfo> entry : retDTO.entrySet()){
            ret.addProvinceCityInfo(entry.getValue());
        }
        BaseResult result = BaseResult.success(ret);
        return result;
    }
}
