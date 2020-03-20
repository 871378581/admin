package com.segama.ege.admin.vo;

import java.util.Objects;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2019-10-26 10:46
 */
public class CarTypeVO {
    private String car_type;

    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarTypeVO carTypeVO = (CarTypeVO) o;
        return Objects.equals(car_type, carTypeVO.car_type) &&
                Objects.equals(id, carTypeVO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car_type, id);
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
