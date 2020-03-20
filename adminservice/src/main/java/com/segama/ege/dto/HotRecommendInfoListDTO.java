package com.segama.ege.dto;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
public class HotRecommendInfoListDTO {
    private List<EachHotRecommendInfo> hotRecommendInfos;

    public List<EachHotRecommendInfo> getHotRecommendInfos() {
        return hotRecommendInfos;
    }

    public void setHotRecommendInfos(List<EachHotRecommendInfo> hotRecommendInfos) {
        this.hotRecommendInfos = hotRecommendInfos;
    }

    public void addHotRecommendInfo(EachHotRecommendInfo bannerInfo){
        this.hotRecommendInfos.add(bannerInfo);
    }

    public HotRecommendInfoListDTO(){
        if (CollectionUtils.isEmpty(hotRecommendInfos)) {
            hotRecommendInfos = new ArrayList<EachHotRecommendInfo>();
        }
    }
}
