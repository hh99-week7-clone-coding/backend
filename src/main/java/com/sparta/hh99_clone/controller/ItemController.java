package com.sparta.hh99_clone.controller;

import com.sparta.hh99_clone.domain.Item;
import com.sparta.hh99_clone.dto.request.ItemRequestDto;
import com.sparta.hh99_clone.repository.ItemRepository;
import com.sparta.hh99_clone.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/api/shop/item")
    public Item save(@RequestBody ItemRequestDto itemRequestDto){
        return itemService.save(itemRequestDto);
    }

    @GetMapping("/api/shop/item")
    public List<Item> show(){
        return itemService.show();
    }

}
