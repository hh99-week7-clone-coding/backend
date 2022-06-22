package com.sparta.hh99_clone.repository;

import com.sparta.hh99_clone.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findByVehicleId(Long vehicleId);

    Optional<Vehicle> findByVehicleName(String vehicleName);
}
