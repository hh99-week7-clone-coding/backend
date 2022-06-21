package com.sparta.hh99_clone.repository;

import com.sparta.hh99_clone.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByCategoryId(String categoryId);

}
