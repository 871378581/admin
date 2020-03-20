package com.segama.ege.dto;

import com.segama.ege.entity.Car;
import com.segama.ege.entity.WxUser;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CarInfoResponseListDTO extends BasePageDTO {

    private List<CarInfoResponseDTO> cars;

    public CarInfoResponseListDTO(){
        if (cars == null) {
            cars = new ArrayList<CarInfoResponseDTO>();
        }
    }

    public void addCar(Car car, WxUser currentLoginUser) {
        if (cars == null) {
            cars = new ArrayList<CarInfoResponseDTO>();
        }

        cars.add(new CarInfoResponseDTO(car, currentLoginUser));
    }

    public void addCars(List<Car> myCars, WxUser currentLoginUser) {
        if (cars == null) {
            cars = new ArrayList<CarInfoResponseDTO>();
        }
        for (int i = 0; i < myCars.size(); ++i){
            addCar(myCars.get(i), currentLoginUser);
        }
    }

    public List<CarInfoResponseDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarInfoResponseDTO> cars) {
        this.cars = cars;
    }
}
