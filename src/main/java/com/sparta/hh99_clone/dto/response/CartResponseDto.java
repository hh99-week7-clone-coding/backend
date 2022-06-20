package com.sparta.hh99_clone.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponseDto {
    private Long itemId;
    private String itemName;
    private String categoryId;
    private String imageUrl;
    private int price;
    private int quantity;

    public CartResponseDto(Long itemId, ItemResponseDto itemResponseDto,int quantity) {
        this.itemId = itemId;
        this.itemName = itemResponseDto.getItemName();
        this.categoryId = itemResponseDto.getCategoryId();
        this.imageUrl = itemResponseDto.getImageUrl();
        this.price = itemResponseDto.getPrice();
        this.quantity = quantity;
    }
}
