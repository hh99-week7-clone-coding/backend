package com.sparta.hh99_clone.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class NonLoginUserCartRequestDto {       // 쿠키에서 받아와야할 itemId, quantity;
    private Long itemId;
    private int quantity;
}
