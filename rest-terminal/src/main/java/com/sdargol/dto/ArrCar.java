package com.sdargol.dto;

import java.util.List;

public class ArrCar {
    private Integer value;
    private List<Car> carList;

    public ArrCar() {
    }

    public ArrCar(Integer value, List<Car> carList) {
        this.value = value;
        this.carList = carList;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
