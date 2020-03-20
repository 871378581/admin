package com.segama.ege.dto;

import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.entity.RepeatServiceWxUsers;
import com.segama.ege.entity.ServiceOrder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepeatServiceWxUsersDTO {
    private String user_id;

    private String user_name;

    private Long car_id;

    private String car_plate;

    private String car_type_name;

    private List<Long> order_id;

    private List<String> order_string_id;

    private List<String> gmt_actual_service;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public String getCar_plate() {
        return car_plate;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getCar_type_name() {
        return car_type_name;
    }

    public void setCar_type_name(String car_type_name) {
        this.car_type_name = car_type_name;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate;
    }

    public List<Long> getOrder_id() {
        return order_id;
    }

    public List<String> getOrder_string_id() {
        return order_string_id;
    }

    public List<String> getGmt_actual_service() {
        return gmt_actual_service;
    }

    public void add(ServiceOrder serviceOrder){
        if(this.gmt_actual_service == null){
            this.gmt_actual_service = new ArrayList<String>();
        }

        if(this.order_string_id == null){
            this.order_string_id = new ArrayList<String>();
        }

        if(this.order_id == null){
            this.order_id = new ArrayList<Long>();
        }

        this.gmt_actual_service.add(DateUtil.parse(serviceOrder.getGmt_actual_service()));
        this.order_id.add(serviceOrder.getId());
        this.order_string_id.add(serviceOrder.getOrder_string_id());

        this.user_id = serviceOrder.getUser_id();
        this.user_name = serviceOrder.getUser_name();
        this.car_id = serviceOrder.getCar_id();
        this.car_plate = serviceOrder.getCar_plate();
        this.car_type_name = serviceOrder.getCar_type_name();
    }

    public static RepeatServiceWxUsersDTO build(ServiceOrder order){
        RepeatServiceWxUsersDTO dto = new RepeatServiceWxUsersDTO();
        dto.add(order);
        return dto;
    }

    public int size(){
        return this.order_id.size();
    }

    public static RepeatServiceWxUsers build(RepeatServiceWxUsersDTO dto){
        RepeatServiceWxUsers result = new RepeatServiceWxUsers();
        result.setCar_id(dto.getCar_id());
        result.setCar_plate(dto.getCar_plate());
        result.setCar_type_name(dto.getCar_type_name());
        result.setGmt_create(new Date());
        result.setUser_id(dto.getUser_id());
        result.setUser_name(dto.getUser_name());

        List<Long> order_ids = dto.getOrder_id();
        if(order_ids.size() > 0){
            String order_id = String.valueOf(order_ids.get(0));
            int m = 1;
            for (; m < order_ids.size(); ++m){
                order_id = order_id + "|" + order_ids.get(m);
            }
            result.setOrder_id(order_id);
        }

        List<String> order_string_ids = dto.getOrder_string_id();
        if(order_string_ids.size() > 0){
            result.setOrder_string_id(make(order_string_ids));
        }

        List<String> gmt_services = dto.getGmt_actual_service();
        if(gmt_services.size() > 0){
            result.setGmt_actual_service(make(gmt_services));
        }
        return result;
    }

    private static String make(List<String> values){
        if(values.size() > 0){
            String s = String.valueOf(values.get(0));
            int m = 1;
            for (; m < values.size(); ++m){
                s = s + "|" + values.get(m);
            }
            return s;
        }
        return "";
    }
}
