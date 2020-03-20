package com.segama.ege.dto;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EachCarTypeInfo {
    private String name;

    private String brandImg;

    private String brand_code;//品牌编码


    Set<String> children;


    Set<Map<String, String>> childrenType;

    public EachCarTypeInfo() {
        this.children = new HashSet<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandImg() {
        return brandImg;
    }

    public void setBrandImg(String brandImg) {
        this.brandImg = brandImg;
    }

    public Set<String> getChildren() {
        return children;
    }

    public void setChildren(Set<String> children) {
        this.children = children;
    }

    public void addChild(String child_name) {
        this.children.add(child_name);
    }

    public void addChild(String child_name, String type_code) {
        if(CollectionUtils.isEmpty(childrenType)){
            childrenType = new HashSet<>();
        }
        HashMap<String, String> entry = new HashMap<>();
        entry.put("typeName",child_name);
        entry.put("typeCode",type_code);
        this.childrenType.add(entry);
    }

    public String getBrand_code() {
        return brand_code;
    }

    public void setBrand_code(String brand_code) {
        this.brand_code = brand_code;
    }

    public Set<Map<String, String>> getChildrenType() {
        return childrenType;
    }

    public void setChildrenType(Set<Map<String, String>> childrenType) {
        this.childrenType = childrenType;
    }
}
