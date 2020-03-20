
package com.segama.ege.dto;

import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class CityRegionInfo {

    private String city;

    private String city_code;

    private Set<String> regions;

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public CityRegionInfo(){
        if (CollectionUtils.isEmpty(regions)) {
            this.regions = new HashSet<String>();
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<String> getRegions() {
        return regions;
    }

    public void addRegion(String region){
        this.regions.add(region);
    }

    public void addRegions(Set<String> newRegions){
        Iterator<String> new_region_iter = newRegions.iterator();
        while (new_region_iter.hasNext()){
            addRegion(new_region_iter.next());
        }
    }
}
