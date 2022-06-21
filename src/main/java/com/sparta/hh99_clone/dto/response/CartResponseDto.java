package com.sparta.hh99_clone.dto.response;

import com.sparta.hh99_clone.domain.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponseDto {
    private String itemName;
    private String imageUrl;
    private int price;
    private int quantity;


    public CartResponseDto(Item item, int quantity) {
        this.itemName = item.getItemName();
        this.imageUrl = item.getImageUrl();
        this.price = item.getPrice();
        this.quantity = quantity;
    }
}
