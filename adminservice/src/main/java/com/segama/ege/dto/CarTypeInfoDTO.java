package com.segama.ege.dto;

import com.segama.ege.dto.EachCarTypeInfo;

import java.util.ArrayList;
import java.util.List;

public class CarTypeInfoDTO {
    private String brand_first_letter;
    private List<EachCarTypeInfo> children;

    public CarTypeInfoDTO(){
        this.children = new ArrayList<EachCarTypeInfo>();
    }

    public String getBrand_first_letter() {
        return brand_first_letter;
    }

    public void setBrand_first_letter(String brand_first_letter) {
        this.brand_first_letter = brand_first_letter;
    }

    public List<EachCarTypeInfo> getChildren() {
        return children;
    }

    public void setChildren(List<EachCarTypeInfo> children) {
        this.children = children;
    }

    public void addEachCarTypeInfo(EachCarTypeInfo info){
        this.children.add(info);
    }
}
