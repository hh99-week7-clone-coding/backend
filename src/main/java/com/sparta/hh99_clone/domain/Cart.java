package com.sparta.hh99_clone.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Column(nullable = false)
    private int quantity;

    @OneToMany
    @JoinColumn(name = "itemId")
    private List<Item> items;   // 리스트 안에 itemName, imageUrl, price, description

}
