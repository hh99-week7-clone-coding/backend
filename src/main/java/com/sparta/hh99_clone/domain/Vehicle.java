package com.sparta.hh99_clone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @Column
    private String vehicleName;

    @Column
    private int basePrice;

    @Column
    private int range;

    @Column
    private double quarterMile;

    @Column
    private int peakPower;

    @Column
    private String wheels;

    @Column
    private double acceleration;

    @Column
    private int topSpeed;

    @Column
    private double dragCoefficient;

    @Column
    private String powertrain;

    @Column
    private int superchargingMax;

    @Column
    private int seating;

    @Column
    private String drive;

    @Column
    private String battery;

    @Column
    private String displays;

    @Column
    private String onboardChargerMax;

    @Column
    private String warranty;

    @Column
    private int towing;
}
