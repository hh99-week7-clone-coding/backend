package com.sparta.hh99_clone.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDto {
    private Long itemId;
    private int quantity;
}
