package com.sparta.hh99_clone.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends Timestamped {         //레스토랑 이라고 생각하자

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
}