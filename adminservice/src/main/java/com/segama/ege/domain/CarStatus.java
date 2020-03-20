package com.segama.ege.domain;

import org.apache.commons.lang3.StringUtils;

public enum CarStatus {
    //车的状态
    not_activated("0", "未激活", true),
    using("1", "使用中", false),
    expired("2", "已过期", true);
    private String code;
    private String desc;
    private boolean allowEdit;

    public static CarStatus parse(String code) {
        if(StringUtils.isBlank(code)){
            return CarStatus.not_activated;
        }
        for (CarStatus carStatus : CarStatus.values()) {
            if (carStatus.getCode().equals(code)) {
                return carStatus;
            }
        }
        return CarStatus.not_activated;
    }

    CarStatus(String code, String desc, boolean allowEdit) {
        this.code = code;
        this.desc = desc;
        this.allowEdit = allowEdit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(boolean allowEdit) {
        this.allowEdit = allowEdit;
    }
}
