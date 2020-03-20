package com.segama.ege.dto;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class RecommendShopResponseListDTO extends BasePageDTO {
    private List<RecommendShopsResponseDTO> dtos;

    public RecommendShopResponseListDTO(){
        if (CollectionUtils.isEmpty(dtos)) {
            dtos = new ArrayList<RecommendShopsResponseDTO>();
        }
    }

    public void addRecommendShopsResponeDTO(RecommendShopsResponseDTO dto){
        this.dtos.add(dto);
    }

    public List<RecommendShopsResponseDTO> getDtos() {
        return dtos;
    }
}
