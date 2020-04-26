package com.segama.ege.admin.vo;

/**
 * 联通同步数据VO
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2020-04-26 23:48
 */
public class SysncDataVO {

    private String param;
    //归属地市：名称
    private String cityName;

    //套餐：编码
    private String pacakgeCode;

    //套餐名称
    private String pacakgeName;

    //合约期
    private String contractPeriod;

    //优惠金额
    private String discountAmount;

    //入网姓名
    private String accessName;

    //身份证号
    private String idNumber;

    //收件人
    private String addressee;

    //收件人电话
    private String addresseePhone;

    //所在区县名称
    private String districtName;
    //详细地址
    private String address;

    //选择号码
    private String selectedPhoneNum;

    //用户是否完成花呗冻结
    private Boolean freeze;

    //用户花呗冻结金额
    private String freezeAmount;

    //订单创建时间 yyyy-MM-dd HH:mm:ss
    private String orderCreateTime;

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPacakgeCode() {
        return pacakgeCode;
    }

    public void setPacakgeCode(String pacakgeCode) {
        this.pacakgeCode = pacakgeCode;
    }

    public String getPacakgeName() {
        return pacakgeName;
    }

    public void setPacakgeName(String pacakgeName) {
        this.pacakgeName = pacakgeName;
    }

    public String getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getAddresseePhone() {
        return addresseePhone;
    }

    public void setAddresseePhone(String addresseePhone) {
        this.addresseePhone = addresseePhone;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSelectedPhoneNum() {
        return selectedPhoneNum;
    }

    public void setSelectedPhoneNum(String selectedPhoneNum) {
        this.selectedPhoneNum = selectedPhoneNum;
    }

    public Boolean getFreeze() {
        return freeze;
    }

    public void setFreeze(Boolean freeze) {
        this.freeze = freeze;
    }

    public String getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(String freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public SysncDataVO() {
    }

    public SysncDataVO(String cityName, String pacakgeCode, String pacakgeName, String contractPeriod, String discountAmount, String accessName, String idNumber, String addressee, String addresseePhone, String districtName, String address, String selectedPhoneNum, Boolean freeze, String freezeAmount, String orderCreateTime) {
        this.cityName = cityName;
        this.pacakgeCode = pacakgeCode;
        this.pacakgeName = pacakgeName;
        this.contractPeriod = contractPeriod;
        this.discountAmount = discountAmount;
        this.accessName = accessName;
        this.idNumber = idNumber;
        this.addressee = addressee;
        this.addresseePhone = addresseePhone;
        this.districtName = districtName;
        this.address = address;
        this.selectedPhoneNum = selectedPhoneNum;
        this.freeze = freeze;
        this.freezeAmount = freezeAmount;
        this.orderCreateTime = orderCreateTime;
    }
}
