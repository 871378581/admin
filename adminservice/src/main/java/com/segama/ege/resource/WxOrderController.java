package com.segama.ege.resource;
import com.segama.ege.dto.ShopConfirmOrderRequestDTO;
import com.segama.ege.dto.*;
import com.segama.ege.entity.WxUser;
import com.segama.ege.entity.WxUserExample;
import com.segama.ege.repository.WxUserMapper;
import com.segama.ege.service.WxOrderService;
import com.segama.ege.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.DefaultValue;
import java.util.*;

@RestController
@RequestMapping("/ege/api/order")
public class WxOrderController {

    @Autowired
    WxOrderService orderService;

    @Resource
    WxUserMapper wxUserMapper;

    @RequestMapping("/getOrderList")
    public BaseResult getOrderList(@RequestParam(value = "user_id", defaultValue = "") String user_id,
                                   @RequestParam(value = "order_status", defaultValue = "ALL") String order_status,
                                   @RequestParam(value = "search_type", defaultValue = "") String search_type,
                                   @RequestParam(value = "keyword", defaultValue = "") String keyword,
                                  @DefaultValue("1") @RequestParam("currentPage") int currentPage,
                                  @DefaultValue("10") @RequestParam("showCount") int showCount) {
        BaseResult result;
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            WxUserExample wxUserExample = new WxUserExample();
            wxUserExample.createCriteria().andUser_idEqualTo(user_id);
            List<WxUser> users = this.wxUserMapper.selectByExample(wxUserExample);
            if(CollectionUtils.isEmpty(users)){
                return BaseResult.buildLoginRequiredResponse();
            }
            currentLoginUser = users.get(0);
        }

        try {
            ServiceOrderResponseListDTO orderList = orderService.getOrderList(currentLoginUser,
                    order_status, search_type, keyword, currentPage, showCount);
            result = BaseResult.success(orderList);
        } catch (Exception e) {
            result = BaseResult.error("500", "获取订单列表失败!");
        }
        return result;
    }

    @RequestMapping("/getOrderInfo")
    public BaseResult getOrderInfo(@RequestParam(value = "user_id", defaultValue = "") String user_id,
                                   @DefaultValue("1") @RequestParam("id") Long order_id) {
        BaseResult result;
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            WxUserExample wxUserExample = new WxUserExample();
            wxUserExample.createCriteria().andUser_idEqualTo(user_id);
            List<WxUser> users = this.wxUserMapper.selectByExample(wxUserExample);
            if(CollectionUtils.isEmpty(users)){
                return BaseResult.buildLoginRequiredResponse();
            }
            currentLoginUser = users.get(0);
        }

        try {
            ServiceOrderDetailResponseDTO order = orderService.getOrderInfo(currentLoginUser, order_id);
            if(order != null){
                result = BaseResult.success(order);
            }else{
                result = BaseResult.error("500", "获取订单支付详情失败!");
            }
        } catch (Exception e) {
            result = BaseResult.error("500", "获取订单支付详情失败!");
        }
        return result;
    }

    @PostMapping("/submitOrder")
    public BaseResult submitOrder(@RequestBody SubmitServiceOrderRequestDTO dto) {
        BaseResult result = null;
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            WxUserExample wxUserExample = new WxUserExample();
            wxUserExample.createCriteria().andUser_idEqualTo(dto.getUser_id());
            List<WxUser> users = this.wxUserMapper.selectByExample(wxUserExample);
            if(CollectionUtils.isEmpty(users)){
                return BaseResult.buildLoginRequiredResponse();
            }
            currentLoginUser = users.get(0);
        }

        Long ret = orderService.submitOrder(currentLoginUser, dto);
        if(ret > 0){
            result = BaseResult.success(ret);
        }else if (ret == -1L){
            result = BaseResult.error("500",
                    "已有未确认的预约订单,无法再预约!");
        }else if (ret == -2L){
            result = BaseResult.error("500",
                    "门店不存在或已经禁用,无法再预约!");
        }else if (ret == -3L){
            result = BaseResult.error("500",
                    "车不存在,无法再预约!");
        }else if(ret == 0L){
            result = BaseResult.error("500",
                    "提交预约订单失败!");
        }else if(ret == -5L){
            result = BaseResult.error("500",
                    "本用户为黑名单用户，提交预约订单失败!");
        }
        return result;
    }

    @PostMapping("/submitEvaluate")
    public BaseResult submitEvaluate(@RequestBody ShopEvaluateRequestDTO dto) {
        BaseResult result = null;
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            WxUserExample wxUserExample = new WxUserExample();
            wxUserExample.createCriteria().andUser_idEqualTo(dto.getUser_id());
            List<WxUser> users = this.wxUserMapper.selectByExample(wxUserExample);
            if(CollectionUtils.isEmpty(users)){
                return BaseResult.buildLoginRequiredResponse();
            }
            currentLoginUser = users.get(0);
        }

        int ret = orderService.submitEvaluate(currentLoginUser, dto);
        if(ret > 0){
            result = BaseResult.success("ok");
        }else if (ret == -1){
            result = BaseResult.error("500",
                    "订单不存在，无法评价!");
        }else if (ret == -2){
            result = BaseResult.error("500",
                    "门店不存在或已经禁用,无法评价!");
        }else if (ret == -3){
            result = BaseResult.error("500",
                    "车不存在或已经禁用,无法评价!");
        }else if(ret == 0){
            result = BaseResult.error("500",
                    "订单状态不正确,无法评价!");
        }

        return result;
    }

    @RequestMapping("/getPayInfo")
    public BaseResult getPayInfo(@RequestParam(value = "user_id", defaultValue = "") String user_id,
                                   @DefaultValue("1") @RequestParam("id") Long order_id) {
        BaseResult result;
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            WxUserExample wxUserExample = new WxUserExample();
            wxUserExample.createCriteria().andUser_idEqualTo(user_id);
            List<WxUser> users = this.wxUserMapper.selectByExample(wxUserExample);
            if(CollectionUtils.isEmpty(users)){
                return BaseResult.buildLoginRequiredResponse();
            }
            currentLoginUser = users.get(0);
        }

        try {
            PayFeeDetailDTO order = orderService.getPayInfo(currentLoginUser, order_id);
            if(order != null){
                result = BaseResult.success(order);
            }else{
                result = BaseResult.error("500", "获取订单详情失败!");
            }
        } catch (Exception e) {
            result = BaseResult.error("500", "获取订单详情失败!");
        }
        return result;
    }

    @PostMapping("/cancelOrder")
    public BaseResult cancelOrder(@RequestBody CancelOrderRequestDTO dto) {
        BaseResult result = null;
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            WxUserExample wxUserExample = new WxUserExample();
            wxUserExample.createCriteria().andUser_idEqualTo(dto.getUser_id());
            List<WxUser> users = this.wxUserMapper.selectByExample(wxUserExample);
            if(CollectionUtils.isEmpty(users)){
                return BaseResult.buildLoginRequiredResponse();
            }
            currentLoginUser = users.get(0);
        }

        int ret = orderService.cancelOrder(currentLoginUser, dto);
        if(ret > 0){
            result = BaseResult.success("ok");
        }else if (ret == -1){
            result = BaseResult.error("500",
                    "订单不存在，无法取消!");
        }else if (ret == -2){
            result = BaseResult.error("500",
                    "订单服务已经取消或正在进行中，无法取消!");
        }
        return result;
    }

    @RequestMapping("/getShopOrderSumInfo")
    public BaseResult getShopOrderSumInfo(@RequestParam("shop_user_id") Long shop_user_id,
                                          @RequestParam("shop_id") Long shop_id){
        BaseResult result = null;
        try {
            ShopOrderSumInfoResponseDTO dto = orderService.getShopOrderSumInfo(shop_user_id, shop_id);
            if(dto != null){
                result = BaseResult.success(dto);
            }else{
                result = BaseResult.error("500", "获取订单汇总信息失败!");
            }
        } catch (Exception e) {
            result = BaseResult.error("500", "获取订单汇总信息失败!");
        }
        return result;
    }

    @RequestMapping("/getScanOrderInfo")
    public BaseResult getScanOrderInfo(@RequestParam("id") Long order_id, @RequestParam("shop_user_id") Long shop_user_id){
        BaseResult result = null;
        try {
            ScanOrderInfoResponseDTO dto = orderService.getScanOrderInfo(order_id, shop_user_id);
            if(dto != null){
                result = BaseResult.success(dto);
            }else{
                result = BaseResult.error("500", "获取订单扫码信息失败!");
            }
        } catch (Exception e) {
            result = BaseResult.error("500", "获取订单扫码信息失败!");
        }
        return result;
    }

    @PostMapping("/uploadPhotoAndStartService")
    public BaseResult uploadPhotoAndStartService(@RequestBody UploadPhotoAndStartServiceRequestDTO dto) {
        BaseResult result = null;
        if(StringUtils.isEmpty(dto.getCar_dashboard_photo_url())
                || StringUtils.isEmpty(dto.getCar_front_photo_url())
                || StringUtils.isEmpty(dto.getCurr_miles())){
            result = BaseResult.error("500",
                    "车辆正面照或仪表盘照或当期公里数为空，无法开始服务!");
        }

        int ret = orderService.uploadPhotoAndStartService(dto);
        if(ret > 0){
            result = BaseResult.success("ok");
        }else if(ret == -1){
            result = BaseResult.error("500","订单不存在，无法开始服务!");
        }else if(ret == -3){
            result = BaseResult.error("500","车辆不存在，无法开始服务!");
        }else if(ret == -2){
            result = BaseResult.error("500","操作员不存在，无法开始服务!");
        }else if(ret == -401){
            result = BaseResult.error("500","当前公里数不能为空，请重新输入后提交");
        }else if(ret == -402){
            result = BaseResult.error("500","还没有达到下次建议维修公里数，过度保养，有害车辆健康");
        }else{
            result = BaseResult.error("500","无法开始服务!");
        }
        return result;
    }

    @PostMapping("/shopConfirmOrder")
    public BaseResult shopConfirmOrder(@RequestBody ShopConfirmOrderRequestDTO dto) {
        BaseResult result = null;
        int ret = orderService.shopConfirmOrder(dto);
        if(ret > 0){
            result = BaseResult.success("ok");
        }else if(ret == -1){
            result = BaseResult.error("500","订单不存在，门店确认订单失败!");
        }else if(ret == -2){
            result = BaseResult.error("500","订单未在预约状态中，门店确认订单失败!");
        }else if(ret == -3){
            result = BaseResult.error("500","订单生成二维码图片失败!");
        }
        return result;
    }

    @PostMapping("/carUserConfirmOrder")
    public BaseResult carUserConfirmOrder(@RequestBody CarUserConfirmOrderRequestDTO dto) {
        BaseResult result = null;
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            WxUserExample wxUserExample = new WxUserExample();
            wxUserExample.createCriteria().andUser_idEqualTo(dto.getUser_id());
            List<WxUser> users = this.wxUserMapper.selectByExample(wxUserExample);
            if(CollectionUtils.isEmpty(users)){
                return BaseResult.buildLoginRequiredResponse();
            }
            currentLoginUser = users.get(0);
        }
        int ret = orderService.carUserConfirmOrder(dto, currentLoginUser);
        if(ret > 0){
            result = BaseResult.success("ok");
        }else if(ret == -1){
            result = BaseResult.error("500","订单不存在，车主确认订单失败!");
        }else if(ret == -2){
            result = BaseResult.error("500","订单未在修改预约服务时间的状态中，无法确认订单!");
        }else if(ret == -3){
            result = BaseResult.error("500","当前用户无该订单，无法确认订单! ordder_id = " + dto.getOrder_id());
        }else if(ret == -4){
            result = BaseResult.error("500","订单生成二维码图片失败!");
        }
        return result;
    }

    @PostMapping("/shopConfirmOrderHavePay")
    public BaseResult shopConfirmOrderHavePay(@RequestBody ShopConfirmOrderHavePayRequestDTO dto) {
        BaseResult result = null;
        int ret = orderService.shopConfirmOrderHavePay(dto);
        if(ret > 0){
            result = BaseResult.success("ok");
        }else if(ret == -1){
            result = BaseResult.error("500","订单不存在，门店确认订单失败!");
        }else if(ret == -2){
            result = BaseResult.error("500","订单未在待确认支付中，门店无法确认订单已支付!");
        }else if(ret == -3){
            result = BaseResult.error("500","订单无支付订单，无法确认订单已支付!");
        }
        return result;
    }

    @PostMapping("/carUserPay")
    public BaseResult carUserPay(@RequestBody CarUserPayRequestDTO dto) {
        BaseResult result = null;
        WxUser currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            WxUserExample wxUserExample = new WxUserExample();
            wxUserExample.createCriteria().andUser_idEqualTo(dto.getUser_id());
            List<WxUser> users = this.wxUserMapper.selectByExample(wxUserExample);
            if(CollectionUtils.isEmpty(users)){
                return BaseResult.buildLoginRequiredResponse();
            }
            currentLoginUser = users.get(0);
        }
        int ret = orderService.carUserPay(dto, currentLoginUser);
        if(ret > 0){
            result = BaseResult.success("ok");
        }else if(ret == -1){
            result = BaseResult.error("500","订单不存在，车主无法支付!");
        }else if(ret == -2){
            result = BaseResult.error("500","订单已经支付成功，无需再次支付!");
        }else if(ret == -3){
            result = BaseResult.error("500","支付订单不存在，无需支付!");
        }else if(ret == -4){
            result = BaseResult.error("500","当前用户无该订单，无需支付!");
        }
        return result;
    }

    @PostMapping("/submitPayFeeDetail")
    public BaseResult submitPayFeeDetail(@RequestBody SubmitPayFeeDetailRequestDTO dto) {
        BaseResult result = null;
        int ret = orderService.submitPayFeeDetail(dto);
        if(ret > 0){
            result = BaseResult.success("ok");
        }else if (ret == -1){
            result = BaseResult.error("500",
                    "订单不存在，无法提交费用明细!");
        }else if (ret == 0){
            result = BaseResult.error("500",
                    "费用明细保存异常!");
        }else if (ret == -2){
            result = BaseResult.error("500",
                    "订单状态不正常,无法提交费用明细!");
        }

        return result;
    }

    @PostMapping("/carUserIgnoreException")
    public BaseResult carUserIgnoreException(@RequestBody CarUserIgnoreExceptionRequestDTO dto) {
        BaseResult result = null;
        CarUserIgnoreExceptionResponseDTO responseDTO = orderService.carUserIgnoreException(dto);
        if(responseDTO != null){
            result = BaseResult.success(responseDTO);
        }else{
            result = BaseResult.error("500",
                    "订单不存在或订单检测无异常,无需忽略检测异常!");
        }
        return result;
    }

    @RequestMapping("/getOrderListByShopId")
    public BaseResult getOrderListByShopId(@DefaultValue("") @RequestParam(value = "shop_id") Long shop_id,
                                   @RequestParam(value = "order_status", defaultValue = "ALL") String order_status,
                                   @RequestParam(value = "search_type", defaultValue = "") String search_type,
                                   @RequestParam(value = "keyword", defaultValue = "") String keyword,
                                   @DefaultValue("1") @RequestParam("currentPage") int currentPage,
                                   @DefaultValue("10") @RequestParam("showCount") int showCount) {
        BaseResult result;

        try {
            ServiceOrderResponseListDTO orderList = orderService.getOrderListByShopId(shop_id, order_status, search_type, keyword, currentPage, showCount);
            result = BaseResult.success(orderList);
        } catch (Exception e) {
            result = BaseResult.error("500", "获取当前门店的订单列表失败!");
        }
        return result;
    }

    @RequestMapping("/getShopOrderInfo")
    public BaseResult getShopOrderInfo(@DefaultValue("1") @RequestParam("order_id") Long order_id) {
        BaseResult result;
        try {
            ShopServiceOrderResponseDTO order = orderService.getShopOrderInfo(order_id);
            if(order != null){
                result = BaseResult.success(order);
            }else{
                result = BaseResult.error("500", "获取门店端的订单详情失败!");
            }
        } catch (Exception e) {
            result = BaseResult.error("500", "获取门店端的订单详情失败!");
        }
        return result;
    }

    @PostMapping("/makeRepeatServiceWxUsers")
    public void makeRepeatServiceWxUsers() {
        this.orderService.makeRepeatServiceWxUsers();
    }
}
