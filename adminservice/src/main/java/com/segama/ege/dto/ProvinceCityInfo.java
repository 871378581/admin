package com.segama.ege.dto;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ProvinceCityInfo {

    private String province;

    private List<CityRegionInfo> cities;

    public ProvinceCityInfo(){
        if (CollectionUtils.isEmpty(cities)) {
            this.cities = new ArrayList<CityRegionInfo>();
        }
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<CityRegionInfo> getCities() {
        return cities;
    }

    public void setCities(List<CityRegionInfo> cities) {
        this.cities = cities;
    }

    public void addCity(CityRegionInfo city){
        this.cities.add(city);
    }

    public void updateCity(int index, CityRegionInfo city){
        if(index >=0 && index < cities.size()){
            this.cities.set(index, city);
        }
    }

    public void updateProvinceCityInfo(ProvinceCityInfo new_province){
        //同一个省,比较同一个市,新省的地市在原省里沒有，就插入，否则就更新原省。
        List<CityRegionInfo> new_cities = new_province.getCities();
        for(int k = 0; k < new_cities.size(); ++k){
            CityRegionInfo new_city = new_cities.get(k);
            List<CityRegionInfo> old_cities = getCities();
            int z = 0;
            for(; z < old_cities.size(); ++z){
                CityRegionInfo old_city = old_cities.get(z);
                if(old_city.getCity_code().equals(new_city.getCity_code())){
                    old_city.addRegions(new_city.getRegions());//会去重。
                    updateCity(z, old_city);
                    break;
                }
            }
            if(z == old_cities.size()){
                addCity(new_city);
            }
        }
    }
}
