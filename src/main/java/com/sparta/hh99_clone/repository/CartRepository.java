package com.sparta.hh99_clone.repository;

import com.sparta.hh99_clone.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByUserId(Long userId);
    List<Cart> findAllByItemId(Long itemId);
}
