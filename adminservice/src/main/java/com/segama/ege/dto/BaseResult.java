package com.segama.ege.dto;

public class BaseResult<T> {
    private boolean success;
    private String errorCode;
    private String errorMessage;
    private T data;

    public static BaseResult buildLoginRequiredResponse() {
        return error("401", "用户未授权登陆");
    }

    public static BaseResult error(String errorCode, String msg) {
        BaseResult toReturn = new BaseResult();
        toReturn.setSuccess(false);
        toReturn.setErrorCode(errorCode);
        toReturn.setErrorMessage(msg);
        return toReturn;
    }

    public static BaseResult error() {
        BaseResult toReturn = new BaseResult();
        toReturn.setSuccess(false);
        return toReturn;
    }

    public static <T> BaseResult success(T data) {
        BaseResult toReturn = new BaseResult();
        toReturn.setSuccess(true);
        toReturn.setData(data);
        return toReturn;
    }

    public static BaseResult noData() {
        return error("404", "没有数据");
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
