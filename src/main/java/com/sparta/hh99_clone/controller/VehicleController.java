package com.sparta.hh99_clone.controller;

import com.sparta.hh99_clone.dto.response.VehicleResponseDto;
import com.sparta.hh99_clone.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    // 차량 모델 상세 조회
    @GetMapping("/api/vehicle/{vehicleId}")
    public VehicleResponseDto getVehicle(@PathVariable Long vehicleId) {
        return vehicleService.getVehicle(vehicleId);
    }

    // 차량 모델 모델명으로 상세 조회
    @GetMapping("/api/vehicle/byName/{vehicleName}")
    public VehicleResponseDto getVehicleByName(@PathVariable String vehicleName) {
        return vehicleService.getVehicleByName(vehicleName);
    }

}
