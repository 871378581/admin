package com.segama.ege.dto;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

public class BannerInfoListDTO {
    private List<EachBannerInfo> banners;

    public List<EachBannerInfo> getBanners() {
        return banners;
    }

    public void setBanners(List<EachBannerInfo> banners) {
        this.banners = banners;
    }

    public void addBannerInfo(EachBannerInfo bannerInfo){
            this.banners.add(bannerInfo);
    }

    public BannerInfoListDTO(){
        if (CollectionUtils.isEmpty(banners)) {
            banners = new ArrayList<EachBannerInfo>();
        }
    }
}
