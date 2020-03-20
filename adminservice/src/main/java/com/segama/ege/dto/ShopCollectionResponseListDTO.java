package com.segama.ege.dto;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ShopCollectionResponseListDTO {
    private List<ShopCollectionResponseDTO> shopCollectionList;

    public ShopCollectionResponseListDTO(){
        if (CollectionUtils.isEmpty(shopCollectionList)) {
            shopCollectionList = new ArrayList<ShopCollectionResponseDTO>();
        }
    }

    public List<ShopCollectionResponseDTO> getShopCollectionList() {
        return shopCollectionList;
    }

    public void setShopCollectionList(List<ShopCollectionResponseDTO> shopCollectionList) {
        this.shopCollectionList = shopCollectionList;
    }

    public void addShopCollection(ShopCollectionResponseDTO shopCollection){
        this.shopCollectionList.add(shopCollection);
    }

    public void addShopCollections(List<ShopCollectionResponseDTO> shopCollections){
        this.shopCollectionList.addAll(shopCollections);
    }
}
