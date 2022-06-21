package com.sparta.hh99_clone.repository;

import com.sparta.hh99_clone.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByCategoryId(String categoryId);
    List<Item> findAllByCategoryId(String categoryId);

}
