package com.segama.ege.dto;

public class EachHotRecommendInfo {
    private String photo_url;

    private String url;

    private long id;

    private long sort_order;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSort_order() {
        return sort_order;
    }

    public void setSort_order(long sort_order) {
        this.sort_order = sort_order;
    }
}
