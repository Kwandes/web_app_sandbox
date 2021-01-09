package dev.hoteals.web_app_sandbox.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    private int car_id;
    private String brand;
    private String model;
    private String color;

    public Car () {

    }

    public Car (int car_id, String brand, String model, String color ) {
        this.car_id = car_id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    //region Getters & Setters
    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int carID) {
        this.car_id = carID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    //endregion

    public String toString()
    {
        return car_id + "|" + brand + " " + model + " - " + color;
    }
}

