package com.sparta.hh99_clone.repository;

import com.sparta.hh99_clone.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
