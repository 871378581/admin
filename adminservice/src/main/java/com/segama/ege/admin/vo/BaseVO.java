package com.segama.ege.admin.vo;
/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2019-10-07 14:37
 */
public class BaseVO<T>{

    private String token;
    private Integer status;
    private String errorMsg;
    private String error;
    private Boolean success;
    private T data;
    private Integer count;
    private Integer code;

    public BaseVO() {
    }

    public BaseVO(String msg, Boolean success){
        this.errorMsg = msg;
        this.success = success;
    }

    private BaseVO(String msg){
        this.errorMsg = msg;
        this.success = false;
    }

    public static BaseVO createFailure(String msg){
        return new BaseVO(msg,false);
    }
    public static BaseVO createSuccess(){
        return new BaseVO("",true);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
