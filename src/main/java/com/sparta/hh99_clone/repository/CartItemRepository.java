package com.sparta.hh99_clone.repository;

import com.sparta.hh99_clone.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
