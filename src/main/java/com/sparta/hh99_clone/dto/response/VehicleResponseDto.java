package com.sparta.hh99_clone.dto.response;

import com.sparta.hh99_clone.domain.Vehicle;
import lombok.Getter;

@Getter
public class VehicleResponseDto {

    private String vehicleName;
    private int basePrice;
    private int range;
    private double quarterMile;
    private int peakPower;
    private String wheels;
    private double acceleration;
    private int topSpeed;
    private double dragCoefficient;
    private String powertrain;
    private int superchargingMax;
    private int seating;
    private String drive;
    private String battery;
    private String displays;
    private String onboardChargerMax;
    private String warranty;
    private int towing;

    public VehicleResponseDto(Vehicle vehicle) {
        this.vehicleName = vehicle.getVehicleName();
        this.basePrice = vehicle.getBasePrice();
        this.range = vehicle.getRange();
        this.quarterMile = vehicle.getQuarterMile();
        this.peakPower = vehicle.getPeakPower();
        this.wheels = vehicle.getWheels();
        this.acceleration = vehicle.getAcceleration();
        this.topSpeed = vehicle.getTopSpeed();
        this.dragCoefficient = vehicle.getDragCoefficient();
        this.powertrain = vehicle.getPowertrain();
        this.superchargingMax = vehicle.getSuperchargingMax();
        this.seating = vehicle.getSeating();
        this.drive = vehicle.getDrive();
        this.battery = vehicle.getBattery();
        this.displays = vehicle.getDisplays();
        this.onboardChargerMax = vehicle.getOnboardChargerMax();
        this.warranty = vehicle.getWarranty();
        this.towing = vehicle.getTowing();
    }
}
