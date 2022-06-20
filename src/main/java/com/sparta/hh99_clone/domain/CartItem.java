package com.sparta.hh99_clone.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartItem {         //cart 안에 들어갈것, food
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private String categoryId;       //내한테 필요한 카테고리

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    private Cart cart;

    public CartItem(String itemName, String categoryId, String imageUrl, int price) {
        this.itemName = itemName;
        this.categoryId = categoryId;
        this.imageUrl = imageUrl;
        this.price = price;
    }
}
