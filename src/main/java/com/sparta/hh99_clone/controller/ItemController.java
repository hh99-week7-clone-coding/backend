package com.sparta.hh99_clone.controller;

import com.sparta.hh99_clone.dto.response.ItemResponseDto;
import com.sparta.hh99_clone.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    // 아이템 전체 리스트
    @GetMapping("/api/shop/category")
    public ResponseEntity<List<ItemResponseDto>> getItems(@RequestParam(required = false) String categoryId) {
        return ResponseEntity.ok().body(itemService.getItems(categoryId));
    }

    @GetMapping("/api/shop/item/{itemId}")  //item 상세 정보 받아오기
    public ItemResponseDto getItem(@PathVariable Long itemId) {
        return itemService.getItem(itemId);
    }
}

