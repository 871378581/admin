package com.segama.ege.dto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import org.springframework.util.CollectionUtils;

public class CarTypeInfoListDTO {
    private List<CarTypeInfoDTO> infos;

    public CarTypeInfoListDTO(){
        if (CollectionUtils.isEmpty(infos)) {
            this.infos = new ArrayList<CarTypeInfoDTO>();
        }
    }

    public List<CarTypeInfoDTO> getInfos() {
        return infos;
    }

    public void setInfos(List<CarTypeInfoDTO> infos) {
        this.infos = infos;
    }
    public void addCarTypeInfoDTO(CarTypeInfoDTO infoDTO){
        this.infos.add(infoDTO);
    }

    public void sortAscByBrandFirstLetter(){
        Collections.sort(infos, new Comparator<CarTypeInfoDTO>() {
            @Override
            public int compare(CarTypeInfoDTO o1, CarTypeInfoDTO o2) {
                return o1.getBrand_first_letter().compareTo(o2.getBrand_first_letter());
            }
        });
    }
}
