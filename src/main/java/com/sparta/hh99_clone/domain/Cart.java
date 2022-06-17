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

    @ManyToOne
    private User user;          // user 와 연관관계 설정

    @ManyToOne
    private Item item;

}