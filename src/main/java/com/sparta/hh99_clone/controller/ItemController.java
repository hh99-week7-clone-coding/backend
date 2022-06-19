package com.sparta.hh99_clone.controller;

import com.sparta.hh99_clone.domain.Item;
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

    @GetMapping("/api/shop/item/{itemId}")  //item 상세 정보 받아오기
    public ItemResponseDto getItem(@PathVariable Long itemId) {
        return itemService.getItem(itemId);
    }

    @GetMapping("/api/shop/category")
    public ResponseEntity<List<ItemResponseDto>> getItems(@RequestParam(required = false) String categoryId) {
//        if (categoryId != null) {
//            return ResponseEntity.ok().body(itemService.findAllByCategoryId(categoryId));
//
//        }else {
//        }
            return ResponseEntity.ok().body(itemService.getItems(categoryId));
        }

}

//최상단 카테고리에 하위 카테고리만 분류가 되게
//
//            - 카테고리 id값으로 들어오고,
//}
