package com.sparta.hh99_clone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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
    private int rangeMiles;

    @Column
    private String imageUrl;

    @Column
    private int seating;

    @Column
    private int cargoCapacity;

    @Column
    private String drive;

    @Column
    private double acceleration;

    @Column
    private int topSpeed;
}
