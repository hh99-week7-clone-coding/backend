package com.sparta.hh99_clone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String imageOverUrl;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String categoryId;
}
