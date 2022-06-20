package com.sparta.hh99_clone.controller;

import com.sparta.hh99_clone.dto.response.SolarResponseDto;
import com.sparta.hh99_clone.service.SolarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SolarController {

    private final SolarService solarService;

    // 태양광 모델 상세 조회
    @GetMapping("/api/solar/{solarId}")
    public SolarResponseDto getSolar(@PathVariable Long solarId) {
        return solarService.getSolar(solarId);
    }
}
