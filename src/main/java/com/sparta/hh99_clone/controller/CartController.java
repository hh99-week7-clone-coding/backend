package com.sparta.hh99_clone.controller;

import com.sparta.hh99_clone.domain.Cart;
import com.sparta.hh99_clone.dto.request.CartRequestDto;
import com.sparta.hh99_clone.dto.response.CartResponseDto;
import com.sparta.hh99_clone.dto.response.ItemResponseDto;
import com.sparta.hh99_clone.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // 장바구니 상품 담기
    @PostMapping("/api/user/{itemId}/cart/add")
    public void saveCart(@PathVariable Long itemId,
                         @RequestBody CartRequestDto cartRequestDto) {
        cartService.saveCart(itemId, cartRequestDto);
    }

    @GetMapping("/api/user/{userId}/cart/add")
    public List<CartResponseDto> showCart(){
        return cartService.showCart();
    }

    // 장바구니안에 상품 삭제
    @DeleteMapping("/api/user/{userId}/cart/{cartId}/delete")
    public void deleteCart(@PathVariable Long userId, @PathVariable Long cartId){
        cartService.deleteCart(userId, cartId);
    }

}


// 장바구니 상품저장
//    @PostMapping("/api/user/{userId}/cart")
//    public CartResponseDto postCart(@RequestBody CartRequestDto cartRequestDto, @PathVariable Long userId){
//        return cartService.postCart(cartRequestDto, userId);
//    }

//    // 장바구니 상품조회
//    @GetMapping("/api/user/{userId}/cart")
//    public List<CartResponseDto> getCart(@PathVariable Long userId){
//        return cartService.getCart(userId);
//    }
