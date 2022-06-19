package com.sparta.hh99_clone.repository;

import com.sparta.hh99_clone.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

//여기다 저장해야됨 카트
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
