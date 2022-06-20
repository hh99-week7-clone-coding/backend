package com.sparta.hh99_clone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @Column(nullable = false)
    private Long itemId;

    @Column(nullable = false)
    private int quantity;

    public CartItem(Long itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }
}
