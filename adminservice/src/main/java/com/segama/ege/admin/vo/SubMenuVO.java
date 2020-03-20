package com.segama.ege.admin.vo;

/**
 * 子菜单
 */
public class SubMenuVO {
    private String text;
    private String icon = "&#xe623;";
    private String href;

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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
