package com.sparta.hh99_clone.domain;

import com.sparta.hh99_clone.dto.request.ItemRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String description;

    public Item(ItemRequestDto itemRequestDto) {
        this.itemName = itemRequestDto.getItemName();
        this.imageUrl = itemRequestDto.getImageUrl();
        this.price = itemRequestDto.getPrice();
        this.description = itemRequestDto.getDescription();
    }
}
