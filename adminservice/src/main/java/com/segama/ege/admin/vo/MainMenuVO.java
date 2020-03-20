package com.segama.ege.admin.vo;

import java.util.List;

/**
 * 主菜单类
 */
public class MainMenuVO {
    private String text;
    private String icon = "&#xe620;";
    private List<SubMenuVO> subset;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<SubMenuVO> getSubset() {
        return subset;
    }

    public void setSubset(List<SubMenuVO> subset) {
        this.subset = subset;
    }
}
