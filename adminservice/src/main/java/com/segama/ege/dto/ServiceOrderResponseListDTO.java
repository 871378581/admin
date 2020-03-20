package com.segama.ege.dto;

import com.segama.ege.entity.Car;
import com.segama.ege.entity.ServiceOrder;
import com.segama.ege.entity.Shop;
import com.segama.ege.entity.WxUser;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceOrderResponseListDTO extends BasePageDTO {

    private List<ServiceOrderResponseDTO> serviceOrderList;

    public ServiceOrderResponseListDTO(){
        if (CollectionUtils.isEmpty(serviceOrderList)) {
            serviceOrderList = new ArrayList<ServiceOrderResponseDTO>();
        }
    }

    public void addServiceOrderResponseDTO(ServiceOrderResponseDTO dto){
        this.serviceOrderList.add(dto);
    }

    public void addServiceOrder(ServiceOrder serviceOrder, Shop shop, Car car,
                                String car_type_img_url, WxUser wxUser){
        this.serviceOrderList.add(ServiceOrderResponseDTO.build(serviceOrder, shop, car,
                car_type_img_url, wxUser));
    }

    public void addServiceOrders(List<ServiceOrder> serviceOrders,
                                 Map<Long, Shop> shop_map,
                                 Map<Long, Car> car_map,
                                 Map<String, WxUser> user_id_map){
        if(!CollectionUtils.isEmpty(serviceOrders)){
            for (ServiceOrder eachOrder: serviceOrders) {
                Car myCar = car_map.get(eachOrder.getCar_id());
                Shop myShop = shop_map.get(eachOrder.getShop_id());
                if( (user_id_map == null) || (user_id_map.get(eachOrder.getUser_id()) == null) ){
                    addServiceOrder(eachOrder, myShop, myCar,
                            myCar.getCar_type_image(), null);
                }else{
                    addServiceOrder(eachOrder, myShop, myCar,
                            myCar.getCar_type_image(), user_id_map.get(eachOrder.getUser_id()));
                }

            }
        }
    }

    public List<ServiceOrderResponseDTO> getServiceOrderList() {
        return serviceOrderList;
    }
}
