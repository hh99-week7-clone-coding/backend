package com.sparta.hh99_clone.dto.response;

import com.sparta.hh99_clone.domain.Vehicle;
import lombok.Getter;

@Getter
public class VehicleResponseDto {

    private String vehicleName;

    private int basePrice;

    private int rangeMiles;

    private String imageUrl;

    private int seating;

    private int cargoCapacity;

    private String drive;

    private double acceleration;

    private int topSpeed;

    public VehicleResponseDto(Vehicle vehicle) {
        this.vehicleName = vehicle.getVehicleName();
        this.basePrice = vehicle.getBasePrice();
        this.rangeMiles = vehicle.getRangeMiles();
        this.imageUrl = vehicle.getImageUrl();
        this.seating = vehicle.getSeating();
        this.cargoCapacity = vehicle.getCargoCapacity();
        this.drive = vehicle.getDrive();
        this.acceleration = vehicle.getAcceleration();
        this.topSpeed = vehicle.getTopSpeed();
    }
}
