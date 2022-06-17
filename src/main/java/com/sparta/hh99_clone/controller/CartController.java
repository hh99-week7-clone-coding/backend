package com.sparta.hh99_clone.controller;

import com.sparta.hh99_clone.dto.request.CartRequestDto;
import com.sparta.hh99_clone.dto.response.CartResponseDto;
import com.sparta.hh99_clone.dto.response.ItemResponseDto;
import com.sparta.hh99_clone.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/api/user/{userId}/cart")
    public CartResponseDto postCart(@RequestBody CartRequestDto cartRequestDto, @PathVariable Long userId){
        return cartService.postCart(cartRequestDto, userId);
    }

//    @GetMapping("/api/user/{userId}/cart")
//    public List<ItemResponseDto> getCart(@PathVariable Long userId){
//    }
//
//    @DeleteMapping("/api/user/{userId}/cart/{cartItemId}/delete")
//    public Long deleteCart(@PathVariable ){
//    }


}
