package com.sparta.hh99_clone.repository;

import com.sparta.hh99_clone.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//    List<Category> findAll();   //findAll > itemRepository로 가야 함
}
