package com.marwa.caroperations.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.marwa.caroperations.entities.Car;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {

    @JsonProperty
    private String carName;
    @JsonProperty
    private String color;
    @JsonProperty
    private String model;
    @JsonProperty
    private String ownerName;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
