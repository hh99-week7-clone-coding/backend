package com.sparta.hh99_clone.service;

import com.sparta.hh99_clone.domain.Solar;
import com.sparta.hh99_clone.dto.response.SolarResponseDto;
import com.sparta.hh99_clone.repository.SolarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SolarService {

    private final SolarRepository solarRepository;

    public SolarResponseDto getSolar(Long solarId) {
        Solar solar = solarRepository.findBySolarId(solarId).orElseThrow(
                () -> new NullPointerException("Not existing solar")
        );
        SolarResponseDto responseDto = new SolarResponseDto(solar);
        return responseDto;
    }
}
