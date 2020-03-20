package com.segama.ege.resource;

import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.domain.AreaTypeEnum;
import com.segama.ege.domain.KeywordTypeEnum;
import com.segama.ege.domain.OrderByFiled;
import com.segama.ege.dto.*;
import com.segama.ege.entity.*;
import com.segama.ege.repository.*;
import com.segama.ege.util.CommonUtil;
import com.segama.ege.util.DistanceComputeUtil;
import com.segama.ege.util.PageCountUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.DefaultValue;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/ege/api/shop")
public class WxShopController {

    @Resource
    private ShopCollectionMapper shopCollectionMapper;

    @Resource
    private ShopPhotoResourceMapper shopPhotoResourceMapper;

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private ShopEvaluateDetailMapper shopEvaluateDetailMapper;

    @Resource
    private EngineOilMapper engineOilMapper;

    @Resource
    private ShopOilSupplyMapper shopOilSupplyMapper;

    /*
    获取已收藏的门店列表
     */
    @RequestMapping("/getShopCollection")
    public BaseResult getShopCollection(@RequestParam(value = "user_id", defaultValue = "") String user_id) {
        BaseResult result;
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            return BaseResult.buildLoginRequiredResponse();
        }
        user_id = currentLoginUser.getUser_id();
        ShopCollectionResponseListDTO listDTO = new ShopCollectionResponseListDTO();
        ShopCollectionExample example = new ShopCollectionExample();
        example.createCriteria().andUser_idEqualTo(user_id).andStatusEqualTo(true);
        example.setOrderByClause("gmt_create desc");
        List<ShopCollection> shopCollections = shopCollectionMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(shopCollections)) {
            for (ShopCollection shopCollection : shopCollections) {
                try {
                    Shop shop = this.shopMapper.selectByPrimaryKey(shopCollection.getShop_id());
                    if (shop == null) {
                        continue;
                    }
                    listDTO.addShopCollection(ShopCollectionResponseDTO.buildOrigin(shopCollection, shop));
                } catch (Exception e) {
                    CommonUtil.info("getShopCollectionDetail", "exception", new Object[]{"shopId=" + shopCollection.getShop_id()}, e);
                }
            }
            result = BaseResult.success(listDTO);
        } else {
            result = BaseResult.error("501", "微信用户user_id不存在!");
        }
        return result;
    }

    private String computeShopEvaluateScore(List<ShopEvaluateDetail> details) {
        double sum = 0;
        int j = 0;
        for (; j < details.size(); ++j) {
            ShopEvaluateDetail detail = details.get(j);
            //汇总评价得分
            sum += Double.parseDouble(detail.getEvaluate_score());
        }
        if (j != 0) {
            double tempD = sum / j;
            BigDecimal b = new BigDecimal(tempD);
            double scoreD = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            return String.valueOf(scoreD);
        }
        return "0";
    }

    /*
    testHDH
    only for test
    */
    //@RequestMapping("/testHDH")
    private BaseResult testHDH() {
        BaseResult result = null;
        ShopExample shopExample = new ShopExample();
        List<Shop> shops = this.shopMapper.selectByExample(shopExample);
        if (!CollectionUtils.isEmpty(shops)) {
            for (int j = 0; j < shops.size(); ++j) {
                Shop eachShop = shops.get(j);
                ShopPhotoResourceExample shopPhotoResourceExample = new ShopPhotoResourceExample();
                shopPhotoResourceExample.createCriteria().andShop_idEqualTo(eachShop.getId());
                shopPhotoResourceExample.setOrderByClause("order_id asc");
                List<ShopPhotoResource> resourceList = shopPhotoResourceMapper.selectByExample(shopPhotoResourceExample);
                if (!CollectionUtils.isEmpty(resourceList)) {
                    String temp_img = "";
                    if (StringUtils.isNotEmpty(resourceList.get(0).getPhoto_url())) {
                        temp_img = resourceList.get(0).getPhoto_url();
                    }
                    for (int i = 1; i < resourceList.size(); ++i) {
                        ShopPhotoResource resource = resourceList.get(i);
                        if (StringUtils.isNotEmpty(resource.getPhoto_url())) {
                            temp_img = temp_img + "|" + resource.getPhoto_url();
                        }
                    }
                    if (StringUtils.isNotEmpty(temp_img)) {
                        eachShop.setDoor_img_url(temp_img);
                        eachShop.setGmt_modify(new Date());
                        this.shopMapper.updateByPrimaryKeySelective(eachShop);
                    }
                }
            }
        }
        result = BaseResult.success("ok");
        return result;
    }

    private void addShopTagInfo(ShopInfoResponseDTO responseDTO, String tags) {
        Set<String> tag_set = new HashSet<String>();
        if (StringUtils.isNotEmpty(tags)) {
            String[] arr_old = tags.split(",");
            for (int m = 0; m < arr_old.length; ++m) {
                tag_set.add(arr_old[m]);
            }
        }
        Iterator<String> it = tag_set.iterator();
        while (it.hasNext()) {
            String tag = it.next();
            ShopEvaluateTagInfo info = new ShopEvaluateTagInfo();
            info.setTag(tag);
            info.setScore(0);
            info.setCount(0);
            responseDTO.addShopEvaluateTagInfo(info);
        }
    }

    /*
    根据门店id获取门店详情
     */
    @RequestMapping("/getShopInfoByID")
    public BaseResult getShopInfoByID(@RequestParam(value = "id") Long shop_id) {
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            return BaseResult.buildLoginRequiredResponse();
        }

        Shop shop = this.shopMapper.selectByPrimaryKey(shop_id);
        if (shop == null) {
            BaseResult result = new BaseResult();
            result.setSuccess(false);//
            result.setErrorCode("503");
            result.setErrorMessage("无法找到对应的门店，门店id=" + shop_id);
            return result;
        }

        ShopInfoResponseDTO responseDTO = new ShopInfoResponseDTO(shop);
        ShopCollectionExample shopCollectionExample = new ShopCollectionExample();
        shopCollectionExample.createCriteria().andUser_idEqualTo(currentLoginUser.getUser_id())
                .andShop_idEqualTo(shop_id).andStatusEqualTo(true);
        List<ShopCollection> shopCollections = this.shopCollectionMapper.selectByExample(shopCollectionExample);
        if (!CollectionUtils.isEmpty(shopCollections)) {
            responseDTO.setIs_collected(true);
        }

        ShopEvaluateDetailExample evaluateDetailExample = new ShopEvaluateDetailExample();
        evaluateDetailExample.createCriteria().andShop_idEqualTo(shop.getId()).andIs_invalidEqualTo(false);
        evaluateDetailExample.setOrderByClause("gmt_evaluate_commit desc");
        List<ShopEvaluateDetail> shopEvaluateDetails = shopEvaluateDetailMapper.selectByExample(evaluateDetailExample);
        responseDTO.setEvaluate_count(shopEvaluateDetails.size());
        responseDTO.setScore(computeShopEvaluateScore(shopEvaluateDetails));
        addShopTagInfo(responseDTO, shop.getEvaluate_tags());

        ShopOilSupplyExample oilSupplyExample = new ShopOilSupplyExample();
        oilSupplyExample.createCriteria().andShop_idEqualTo(shop_id);
        List<ShopOilSupply> oilSupplies = this.shopOilSupplyMapper.selectByExample(oilSupplyExample);
        Set<Long> oil_ids = new HashSet<Long>();
        for (int k = 0; k < oilSupplies.size(); ++k) {
            oil_ids.add(oilSupplies.get(k).getOil_id());
        }

        List<Long> oil_id_list = new ArrayList<Long>();
        for (Long value : oil_ids) {
            oil_id_list.add(value);
        }

        if (oil_id_list.size() > 0) {
            EngineOilExample oilExample = new EngineOilExample();
            oilExample.createCriteria().andIdIn(oil_id_list);
            oilExample.setOrderByClause("oil_type desc,gmt_create desc");
            List<EngineOil> engineOils = this.engineOilMapper.selectByExample(oilExample);
            for (EngineOil engineOil : engineOils) {
                responseDTO.addOil(new OilInfoResponseDTO(engineOil));
            }
        }
        return BaseResult.success(responseDTO);
    }

    /*
    根据区域、门店名称搜索门店列表
     */
    @RequestMapping("/getShopByKeywordAndArea")
    public BaseResult getShopByKeywordAndArea(
            @RequestParam(value = "user_id", defaultValue = "") String user_id,
            @RequestParam(value = "keyword") String keyword,
            @RequestParam(value = "area_name") String area_name,
            @DefaultValue("1") @RequestParam("currentPage") int currentPage,
            @DefaultValue("10") @RequestParam("showCount") int showCount,
            @RequestParam(value = "longitude") String longitudeStr,
            @RequestParam(value = "latitude") String latitudeStr,
            @RequestParam(value = "search_type") String search_type,
            @RequestParam(value = "order_field") String order_field) {

        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            return BaseResult.buildLoginRequiredResponse();
        }
        user_id = currentLoginUser.getUser_id();

        if (search_type.equals(KeywordTypeEnum.shop_name.getCode())) {
            return getShopByShopNameAndArea(user_id, keyword, area_name, currentPage, showCount, longitudeStr,
                    latitudeStr, order_field);
        } else if (search_type.equals(KeywordTypeEnum.oil_brand_name.getCode())) {
            return getShopByOilNameAndArea(user_id, keyword, area_name, currentPage, showCount, longitudeStr,
                    latitudeStr, order_field);
        }
        return null;
    }


    @Resource
    private ProvCityAreaMapper provCityAreaMapper;

    /*
    根据区域、门店名称搜索门店列表
     */
    private BaseResult getShopByShopNameAndArea(String user_id, String shop_name_keyword, String area_name,
                                                int currentPage, int showCount,
                                                String longitudeStr, String latitudeStr, String order_field) {
        BaseResult result = null;
        ShopResponseListDTO listDTO = new ShopResponseListDTO();

        ShopExample example = new ShopExample();

        ShopExample.Criteria shopCriteria = example.or();
        shopCriteria.andIs_disableEqualTo(false);

        if (StringUtils.isNotEmpty(shop_name_keyword)) {
            shopCriteria.andEnterprise_nameLike(("%" + shop_name_keyword + "%"));
        }

        String new_area_name = dealAddressArea(area_name);
        if (StringUtils.isNotEmpty(new_area_name)) {
            shopCriteria.andAddressLike(("%" + new_area_name + "%"));
        }

        example.setOrderByClause("gmt_create desc");
        int totalRecord = shopMapper.countByExample(example);
        if (totalRecord == 0) {
            //降级到区对应的城市进行搜索
            ProvCityAreaExample provCityAreaExample = new ProvCityAreaExample();
            ProvCityAreaExample.Criteria criteria = provCityAreaExample.createCriteria();
            criteria.andIs_disableEqualTo(false);
            criteria.andTypeEqualTo(AreaTypeEnum.district.getCode());
            criteria.andCode_nameEqualTo(area_name);
            List<ProvCityArea> areaList = provCityAreaMapper.selectByExample(provCityAreaExample);
            if (!CollectionUtils.isEmpty(areaList)) {
                ProvCityArea area = areaList.get(0);
                provCityAreaExample = new ProvCityAreaExample();
                ProvCityAreaExample.Criteria criteria1 = provCityAreaExample.createCriteria();
                criteria1.andIs_disableEqualTo(false);
                String parent_code = area.getParent_code();
                criteria1.andTypeEqualTo(AreaTypeEnum.city.getCode());
                criteria1.andCodeEqualTo(parent_code);
                List<ProvCityArea> cityAreaList = provCityAreaMapper.selectByExample(provCityAreaExample);
                if (!CollectionUtils.isEmpty(cityAreaList)) {

                    example = new ShopExample();

                    shopCriteria = example.or();
                    shopCriteria.andIs_disableEqualTo(false);

                    if (StringUtils.isNotEmpty(shop_name_keyword)) {
                        shopCriteria.andEnterprise_nameLike(("%" + shop_name_keyword + "%"));
                    }
                    shopCriteria.andAddressLike(("%" + cityAreaList.get(0).getCode_name() + "%"));

                    totalRecord = shopMapper.countByExample(example);
                }
            }
        }
        int totalPage = PageCountUtil.computeTotalPageByCount(totalRecord, showCount);
        listDTO.addPageInfo(totalPage, currentPage);

        //有可能涉及到地址精度计算，不能分页查询
        List<Shop> shops = shopMapper.selectByExample(example);
        Set<Long> shopCollectIdSet = getShopCollectIdSet(user_id);

        if (!CollectionUtils.isEmpty(shops)) {
            listDTO = generateResult(latitudeStr, longitudeStr, order_field, shopCollectIdSet,
                    shops, currentPage, showCount);
            listDTO.addPageInfo(totalPage, currentPage);
            result = BaseResult.success(listDTO);
        } else {
            result = BaseResult.noData();
        }

        return result;
    }

    private String dealAddressArea(String area_name) {
        if (StringUtils.isNotEmpty(area_name)) {
            if (area_name.endsWith("省") || area_name.endsWith("市")
                    || area_name.endsWith("区") || area_name.endsWith("县")) {
                //兼容地址类似于“杭州天目山路”这样的杭州市区内的门店
                String noCityStr = area_name.substring(0, area_name.length() - 1);
                return noCityStr;
            }
        }
        return area_name;
    }

    private Set<Long> getShopCollectIdSet(String user_id) {
        ShopCollectionExample shopCollectionExample = new ShopCollectionExample();
        shopCollectionExample.createCriteria().andUser_idEqualTo(user_id).andStatusEqualTo(true);
        shopCollectionExample.setOrderByClause("gmt_create desc");
        List<ShopCollection> shopCollections = shopCollectionMapper.selectByExample(shopCollectionExample);
        Set<Long> shopCollectIdSet = new HashSet<Long>();
        for (int j = 0; j < shopCollections.size(); ++j) {
            shopCollectIdSet.add(shopCollections.get(j).getShop_id());
        }
        return shopCollectIdSet;
    }

    /*
    根据区域、机油名称搜索门店列表
     */
    private BaseResult getShopByOilNameAndArea(String user_id, String oil_brand_name_keyword, String area_name,
                                               int currentPage, int showCount,
                                               String longitudeStr, String latitudeStr,
                                               String order_field) {
        BaseResult result = null;
        ShopResponseListDTO listDTO = new ShopResponseListDTO();
        EngineOilExample engineOilExample = new EngineOilExample();
        EngineOilExample.Criteria engineOilExampleCriteria = engineOilExample.createCriteria();
        if (StringUtils.isNotEmpty(oil_brand_name_keyword)) {
            engineOilExampleCriteria.andBrand_nameLike(("%" + oil_brand_name_keyword + "%"));
        }
        List<EngineOil> engineOils = this.engineOilMapper.selectByExample(engineOilExample);
        if (!CollectionUtils.isEmpty(engineOils)) {
            List<Long> oilIds = new ArrayList<Long>();
            for (EngineOil eachOil : engineOils) {
                oilIds.add(eachOil.getId());
            }
            ShopOilSupplyExample oilSupplyExample = new ShopOilSupplyExample();
            ShopOilSupplyExample.Criteria oilCriteria = oilSupplyExample.createCriteria();
            oilCriteria.andOil_idIn(oilIds);
            List<ShopOilSupply> shopOilSupplies = this.shopOilSupplyMapper.selectByExample(oilSupplyExample);
            if (!CollectionUtils.isEmpty(shopOilSupplies)) {
                List<Long> shopIds = new ArrayList<Long>();
                for (ShopOilSupply eachOilSupply : shopOilSupplies) {
                    shopIds.add(eachOilSupply.getShop_id());
                }
                ShopExample shopExample = new ShopExample();
                ShopExample.Criteria shopCriteria = shopExample.or();
                shopCriteria.andIs_disableEqualTo(false);
                shopCriteria.andIdIn(shopIds);
                String new_area_name = dealAddressArea(area_name);
                if (StringUtils.isNotEmpty(new_area_name)) {
                    shopCriteria.andAddressLike(("%" + new_area_name + "%"));
                }

                int totalRecord = shopMapper.countByExample(shopExample);
                int totalPage = PageCountUtil.computeTotalPageByCount(totalRecord, showCount);

                //有可能涉及到地址精度计算，不能分页查询
                shopExample.setOrderByClause("gmt_create desc");
                List<Shop> shops = shopMapper.selectByExample(shopExample);
                Set<Long> shopCollectIdSet = getShopCollectIdSet(user_id);
                if (!CollectionUtils.isEmpty(shops)) {
                    listDTO = generateResult(latitudeStr, longitudeStr, order_field, shopCollectIdSet,
                            shops, currentPage, showCount);
                }

                listDTO.addPageInfo(totalPage, currentPage);
                result = BaseResult.success(listDTO);
            } else {
                result = BaseResult.noData();
            }
        } else {
            result = BaseResult.noData();
        }
        return result;
    }

    private ShopResponseListDTO generateResult(String latitudeStr, String longitudeStr, String order_field,
                                               Set<Long> shopCollectIdSet, List<Shop> shops,
                                               int currentPage, int showCount) {
        ShopResponseListDTO listDTO = new ShopResponseListDTO();
        for (int k = 0; k < shops.size(); ++k) {
            Shop myShop = shops.get(k);
            ShopInfoResponseDTO eachDTO = new ShopInfoResponseDTO(myShop);
            if (shopCollectIdSet.contains(myShop.getId())) {
                eachDTO.setIs_collected(true);
            }
            if (myShop.getLatitude().doubleValue() > 0 && myShop.getLatitude().doubleValue() > 0
                    && StringUtils.isNotEmpty(latitudeStr) && StringUtils.isNotEmpty(longitudeStr)
                    && Double.parseDouble(latitudeStr) > 0 && Double.parseDouble(longitudeStr) > 0) {
                eachDTO.setDistance(DistanceComputeUtil.getDistance(myShop.getLatitude().doubleValue(),
                        myShop.getLongitude().doubleValue(),
                        Double.parseDouble(latitudeStr), Double.parseDouble(longitudeStr)));
            }

            ShopEvaluateDetailExample evaluateDetailExample = new ShopEvaluateDetailExample();
            evaluateDetailExample.createCriteria().andShop_idEqualTo(myShop.getId()).andIs_invalidEqualTo(false);
            evaluateDetailExample.setOrderByClause("gmt_evaluate_commit desc");
            List<ShopEvaluateDetail> details = shopEvaluateDetailMapper.selectByExample(evaluateDetailExample);
            addShopTagInfo(eachDTO, myShop.getEvaluate_tags());

            for (int j = 0; j < details.size(); ++j) {
                ShopEvaluateDetailInfoDTO detailInfoDTO = ShopEvaluateDetailInfoDTO.build(details.get(j));
                eachDTO.addShopEvaluateDetailInfo(detailInfoDTO);
            }
            eachDTO.setEvaluate_count(details.size());
            eachDTO.setScore(computeShopEvaluateScore(details));
            listDTO.addShopInfoResponseDTO(eachDTO);
        }
        if (StringUtils.isNotEmpty(order_field)) {
            if (order_field.equals(OrderByFiled.distance_near.getCode())) {
                listDTO.sortAscByDistance();
            }
            if (order_field.equals(OrderByFiled.distance_far.getCode())) {
                listDTO.sortDescByDistance();
            } else if (order_field.equals(OrderByFiled.high_score.getCode())) {
                listDTO.sortAscByScore();
            } else if (order_field.equals(OrderByFiled.low_score.getCode())) {
                listDTO.sortDescByScore();
            }
        }

        List<ShopInfoResponseDTO> allDTO = listDTO.getShops();
        ShopResponseListDTO retDTO = new ShopResponseListDTO();
        for (int m = (currentPage - 1) * showCount; m < currentPage * showCount && m < allDTO.size() && m >= 0; ++m) {
            retDTO.addShopInfoResponseDTO(allDTO.get(m));
        }
        return retDTO;
    }

    /*
    收藏、取消收藏门店
     */
    @PostMapping("/collect")
    public BaseResult collectShop(@RequestBody ShopCollectionRequestDTO dto) {
        BaseResult result = new BaseResult();
        Date now = new Date();
        if (StringUtils.isNotEmpty(dto.getUser_id()) && dto.getShop_id() > 0) {
            ShopCollectionExample example = new ShopCollectionExample();
            example.createCriteria().andUser_idEqualTo(dto.getUser_id())
                    .andShop_idEqualTo(dto.getShop_id());
            List<ShopCollection> collections = shopCollectionMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(collections)) {
                ShopCollection tempCollection = collections.get(0);
                if (tempCollection.getStatus() && dto.isStatus()) {
                    result.setSuccess(false);//请求收藏，且已经收藏
                    result.setErrorCode("503");
                    result.setErrorMessage("该用户已经收藏该门店！");
                    return result;
                } else if (!tempCollection.getStatus() && dto.isStatus()) {
                    tempCollection.setStatus(true);//请求收藏，且已取消收藏
                    tempCollection.setGmt_modify(now);
                    tempCollection.setVersion(tempCollection.getVersion() + 1);
                    this.shopCollectionMapper.updateByPrimaryKeySelective(tempCollection);
                    result.setSuccess(true);
                    return result;
                } else if (tempCollection.getStatus() && !dto.isStatus()) {
                    tempCollection.setStatus(false);//请求取消，且已经收藏
                    tempCollection.setGmt_modify(now);
                    tempCollection.setVersion(tempCollection.getVersion() + 1);
                    this.shopCollectionMapper.updateByPrimaryKeySelective(tempCollection);
                    result.setSuccess(true);
                    return result;
                } else if (!tempCollection.getStatus() && !dto.isStatus()) {
                    result.setSuccess(false);//已经取消收藏，无法请求取消收藏
                    result.setErrorCode("503");
                    result.setErrorMessage("该用户未收藏该门店，无法取消收藏！");
                    return result;
                }
            } else {
                if (dto.isStatus()) {
                    //无记录，且请求收藏
                    ShopCollection myCollection = new ShopCollection();
                    myCollection.setShop_id(dto.getShop_id());
                    myCollection.setUser_id(dto.getUser_id());
                    myCollection.setGmt_collect(now);
                    myCollection.setGmt_create(now);
                    myCollection.setStatus(true);
                    myCollection.setVersion(0);
                    this.shopCollectionMapper.insert(myCollection);
                    result.setSuccess(true);
                } else {
                    result.setSuccess(false);//无记录，且请求取消收藏
                    result.setErrorCode("503");
                    result.setErrorMessage("该用户未收藏该门店，无法取消收藏！");
                    return result;
                }
            }
        } else {
            result = BaseResult.error("500", "参数检查失败，无法收藏。");
        }
        return result;
    }

    /*
    获取推荐门店信息
     */
    @RequestMapping("/getShopRecommend")
    public BaseResult getShopRecommend(@RequestParam(value = "longitude") String longitudeStr,
                                       @RequestParam(value = "latitude") String latitudeStr,
                                       @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                       @RequestParam(value = "showCount", defaultValue = "15") int showCount) {
        BaseResult result = null;
        RecommendShopResponseListDTO listDTO = new RecommendShopResponseListDTO();
        ShopExample example = new ShopExample();
        example.createCriteria().andIs_recommendEqualTo(true).andIs_disableEqualTo(false);

        int totalRecord = shopMapper.countByExample(example);
        int totalPage = PageCountUtil.computeTotalPageByCount(totalRecord, showCount);
        listDTO.addPageInfo(totalPage, currentPage);

        example.setPageIndex(currentPage);
        example.setPageCount(showCount);
        example.setOrderByClause("gmt_recommend desc, score desc");
        List<Shop> shops = this.shopMapper.selectByExample(example);

        if (!CollectionUtils.isEmpty(shops)) {
            for (int i = 0; i < shops.size(); ++i) {
                Shop recommendShop = shops.get(i);
                RecommendShopsResponseDTO eachDTO = new RecommendShopsResponseDTO();
                eachDTO.setAddress(recommendShop.getAddress());
                eachDTO.setEnterprise_name(recommendShop.getEnterprise_name());
                eachDTO.setId(recommendShop.getId());
                ShopEvaluateDetailExample evaluateDetailExample = new ShopEvaluateDetailExample();
                evaluateDetailExample.createCriteria().andShop_idEqualTo(recommendShop.getId()).andIs_invalidEqualTo(false);
                evaluateDetailExample.setOrderByClause("gmt_evaluate_commit desc");
                List<ShopEvaluateDetail> shopEvaluateDetails = shopEvaluateDetailMapper.selectByExample(evaluateDetailExample);
                eachDTO.setScore(computeShopEvaluateScore(shopEvaluateDetails));
                eachDTO.setService(recommendShop.getService());
                eachDTO.setDoor_img_url(recommendShop.getDoor_img_url());
                eachDTO.setBusiness_hour_start(recommendShop.getBusiness_hour_start());
                eachDTO.setBusiness_hour_end(recommendShop.getBusiness_hour_end());
                eachDTO.setLogo_img_url(recommendShop.getLogo_img_url());
                eachDTO.setSmall_img_url(recommendShop.getSmall_img_url());
                eachDTO.setGmt_recommend(DateUtil.parse(recommendShop.getGmt_recommend()));
                eachDTO.setIs_order(true);//todo
                if (StringUtils.isNotEmpty(latitudeStr)
                        && StringUtils.isNotEmpty(longitudeStr)
                        && Double.parseDouble(latitudeStr) > 0
                        && Double.parseDouble(longitudeStr) > 0
                        && recommendShop.getLatitude().doubleValue() > 0
                        && recommendShop.getLongitude().doubleValue() > 0) {
                    Double addressD = DistanceComputeUtil.getDistance(
                            Double.parseDouble(latitudeStr),
                            Double.parseDouble(longitudeStr),
                            recommendShop.getLatitude().doubleValue(),
                            recommendShop.getLongitude().doubleValue());
                    eachDTO.setDistance(addressD.longValue());
                }
                Set<String> tag_set = new HashSet<String>();
                if (StringUtils.isNotEmpty(recommendShop.getEvaluate_tags())) {
                    String[] arr_old = recommendShop.getEvaluate_tags().split(",");
                    for (int m = 0; m < arr_old.length; ++m) {
                        tag_set.add(arr_old[m]);
                    }
                }
                Iterator<String> it = tag_set.iterator();
                while (it.hasNext()) {
                    String tag = it.next();
                    ShopEvaluateTagInfo info = new ShopEvaluateTagInfo();
                    info.setTag(tag);
                    info.setScore(0);
                    info.setCount(0);
                    eachDTO.addShopEvaluateTagInfo(info);
                }
                listDTO.addRecommendShopsResponeDTO(eachDTO);
            }
            result = BaseResult.success(listDTO);
        } else {
            result = BaseResult.noData();
        }
        return result;
    }

    /*
    根据门店id获取门店评价详情
     */
    @RequestMapping("/getShopEvaluateInfoByShopID")
    public BaseResult getShopEvaluateInfoByShopID(@RequestParam(value = "id") Long shop_id,
                                                  @DefaultValue("1") @RequestParam("currentPage") int currentPage,
                                                  @DefaultValue("10") @RequestParam("showCount") int showCount) {
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            return BaseResult.buildLoginRequiredResponse();
        }

        Shop shop = this.shopMapper.selectByPrimaryKey(shop_id);
        if (shop == null) {
            BaseResult result = new BaseResult();
            result.setSuccess(false);//
            result.setErrorCode("503");
            result.setErrorMessage("无法找到对应的门店，门店id=" + shop_id);
            return result;
        }

        ShopInfoResponseDTO responseDTO = new ShopInfoResponseDTO(shop);

        ShopEvaluateDetailExample evaluateDetailExample = new ShopEvaluateDetailExample();
        ShopEvaluateDetailExample.Criteria criteria = evaluateDetailExample.createCriteria();
        criteria.andShop_idEqualTo(shop.getId()).andIs_invalidEqualTo(false);
        evaluateDetailExample.setOrderByClause("gmt_evaluate_commit desc");

        int totalRecord = shopEvaluateDetailMapper.countByExample(evaluateDetailExample);
        int totalPage = PageCountUtil.computeTotalPageByCount(totalRecord, showCount);
        responseDTO.addPageInfo(totalPage, currentPage);

        evaluateDetailExample.setPageIndex(currentPage);
        evaluateDetailExample.setPageCount(showCount);
        List<ShopEvaluateDetail> details = shopEvaluateDetailMapper.selectByExample(evaluateDetailExample);

        for (int j = 0; j < details.size(); ++j) {
            ShopEvaluateDetailInfoDTO detailInfoDTO = ShopEvaluateDetailInfoDTO.build(details.get(j));
            responseDTO.addShopEvaluateDetailInfo(detailInfoDTO);
        }
        responseDTO.setEvaluate_count(details.size());
        return BaseResult.success(responseDTO);
    }
}
