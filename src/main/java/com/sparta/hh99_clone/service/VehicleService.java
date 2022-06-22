package com.sparta.hh99_clone.service;

import com.sparta.hh99_clone.domain.Vehicle;
import com.sparta.hh99_clone.dto.response.VehicleResponseDto;
import com.sparta.hh99_clone.exception.CustomException;
import com.sparta.hh99_clone.exception.ErrorCode;
import com.sparta.hh99_clone.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    // 차량 모델 상세 조회
    public VehicleResponseDto getVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findByVehicleId(vehicleId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_VEHICLE)
        );
        VehicleResponseDto responseDto = new VehicleResponseDto(vehicle);
        return responseDto;
    }

    // 차량 모델 모델명으로 상세 조회
    public VehicleResponseDto getVehicleByName(String vehicleName) {
        Vehicle vehicle = vehicleRepository.findByVehicleName(vehicleName).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_VEHICLE)
        );
        VehicleResponseDto responseDto = new VehicleResponseDto(vehicle);
        return responseDto;
    }
}
