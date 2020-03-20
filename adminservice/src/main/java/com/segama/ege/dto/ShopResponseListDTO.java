package com.segama.ege.dto;

import com.segama.ege.entity.Shop;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class ShopResponseListDTO extends BasePageDTO {

    private List<ShopInfoResponseDTO> shops;

    public ShopResponseListDTO(){
        if (CollectionUtils.isEmpty(shops)) {
            shops = new ArrayList<ShopInfoResponseDTO>();
        }
    }

    public void addShop(Shop shop) {
        if (CollectionUtils.isEmpty(shops)) {
            shops = new ArrayList<ShopInfoResponseDTO>();
        }
        shops.add(new ShopInfoResponseDTO(shop));
    }

    public void addShopInfoResponseDTO(ShopInfoResponseDTO dto){
        this.shops.add(dto);
    }

    public void addShopInfoResponseDTOs(List<ShopInfoResponseDTO> dtos){
        this.shops.addAll(dtos);
    }

    public void addShops(List<Shop> shopList) {
        if (CollectionUtils.isEmpty(this.shops)) {
            this.shops = new ArrayList<ShopInfoResponseDTO>();
        }
        for (int i = 0; i < shopList.size(); ++i){
            addShop(shopList.get(i));
        }
    }

    public List<ShopInfoResponseDTO> getShops() {
        return shops;
    }

    public void sortAscByDistance(){
        Collections.sort(shops, new Comparator<ShopInfoResponseDTO>() {
            @Override
            public int compare(ShopInfoResponseDTO o1, ShopInfoResponseDTO o2) {
                if(o2.getDistance() > o1.getDistance())
                    return -1;
                if(o2.getDistance() < o1.getDistance())
                    return 1;
                return 0;
            }
        });
    }

    public void sortDescByDistance(){
        Collections.sort(shops, new Comparator<ShopInfoResponseDTO>() {
            @Override
            public int compare(ShopInfoResponseDTO o1, ShopInfoResponseDTO o2) {
                if(o1.getDistance() > o2.getDistance())
                    return -1;
                if(o1.getDistance() < o2.getDistance())
                    return 1;
                return 0;
            }
        });
    }

    public void sortAscByScore(){
        Collections.sort(shops, new Comparator<ShopInfoResponseDTO>() {
            @Override
            public int compare(ShopInfoResponseDTO o1, ShopInfoResponseDTO o2) {
                Double score1 = Double.parseDouble(o1.getScore());
                Double score2 = Double.parseDouble(o2.getScore());
                if(score1 > score2)
                    return -1;
                if(score1 < score2)
                    return 1;
                return 0;
            }
        });
    }

    public void sortDescByScore(){
        Collections.sort(shops, new Comparator<ShopInfoResponseDTO>() {
            @Override
            public int compare(ShopInfoResponseDTO o1, ShopInfoResponseDTO o2) {
                Double score1 = Double.parseDouble(o1.getScore());
                Double score2 = Double.parseDouble(o2.getScore());
                if(score2 > score1)
                    return -1;
                if(score2 < score1)
                    return 1;
                return 0;
            }
        });
    }
}
