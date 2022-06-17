package com.sparta.hh99_clone.dto.response;

import com.sparta.hh99_clone.domain.Solar;
import lombok.Getter;

@Getter
public class SolarResponseDto {

    private String solarName;

    public SolarResponseDto(Solar solar) {
        this.solarName = solar.getSolarName();
    }
}
