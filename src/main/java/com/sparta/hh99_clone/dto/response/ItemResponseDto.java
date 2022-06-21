package com.sparta.hh99_clone.dto.response;

import com.sparta.hh99_clone.domain.Item;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ItemResponseDto {  // get 할때 필요한 애들

    private Long itemId;

    private String itemName;

    private String imageUrl;

    private String imageOverUrl;

    private int price;

    private String description;

    private String categoryId;


    public ItemResponseDto(Item item) { // 받아온 entity를 dto로 반환하겠다.
        this.itemId = item.getItemId();
        this.itemName = item.getItemName();
        this.imageUrl = item.getImageUrl();
        this.imageOverUrl = item.getImageOverUrl();
        this.price = item.getPrice();
        this.description = item.getDescription();
        this.categoryId = item.getCategoryId();
    }
}

