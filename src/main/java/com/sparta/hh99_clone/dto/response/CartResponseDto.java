package com.sparta.hh99_clone.dto.response;

import com.sparta.hh99_clone.domain.Item;
import lombok.Getter;

import java.util.List;

@Getter
public class CartResponseDto {
    private List<Item> items;
    private int quantity;
}
