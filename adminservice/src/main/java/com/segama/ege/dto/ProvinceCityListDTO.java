package com.segama.ege.dto;

import org.springframework.util.CollectionUtils;

import java.util.*;

public class ProvinceCityListDTO {
    private List<ProvinceCityInfo> infos;

    public List<ProvinceCityInfo> getInfos() {
        return infos;
    }

    public ProvinceCityListDTO(){
        if (CollectionUtils.isEmpty(infos)) {
            this.infos = new ArrayList<ProvinceCityInfo>();
        }
    }

    public void addProvinceCityInfo(ProvinceCityInfo info){
        this.infos.add(info);
    }

    public void updateProvinceCityInfo(List<ProvinceCityInfo> newInfos){
        if(CollectionUtils.isEmpty(newInfos)){
            return;
        }

        for(int i = 0; i < newInfos.size(); ++i){
            ProvinceCityInfo new_province = newInfos.get(i);
            int j = 0;
            for (; j < this.infos.size(); ++j){
                ProvinceCityInfo old_province = infos.get(j);
                if (old_province.getProvince().equals(new_province.getProvince())){
                    old_province.updateProvinceCityInfo(new_province);
                    infos.set(j,old_province);
                }
            }
            if(j == this.infos.size()){
                this.infos.add(new_province);
            }
        }
    }
}
