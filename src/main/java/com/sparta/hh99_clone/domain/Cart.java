package com.sparta.hh99_clone.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends Timestamped {         //레스토랑 이라고 생각하자

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;          // user 와 연관관계 설정

    @Column(nullable = false)
    private Long itemId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private boolean checked;        // 카트안에 아이템이 있는지 없는지

    public Cart(User user, Long itemId, int quantity) {
        this.user = user;
        this.itemId = itemId;
        this.quantity = quantity;
        this.checked = true;
    }
}