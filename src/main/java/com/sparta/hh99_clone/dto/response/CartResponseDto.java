package com.sparta.hh99_clone.dto.response;

import com.sparta.hh99_clone.domain.CartItem;
import lombok.Getter;

import java.util.List;

@Getter
public class CartResponseDto {
    private List<CartItem> cartItem;
    private int quantity;
}
