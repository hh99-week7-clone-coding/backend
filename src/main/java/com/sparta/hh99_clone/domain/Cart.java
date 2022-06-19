package com.sparta.hh99_clone.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {         //레스토랑 이라고 생각하자

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Column(nullable = false)
    private int quantity;

    @OneToOne
    private User user;          // user 와 연관관계 설정

}