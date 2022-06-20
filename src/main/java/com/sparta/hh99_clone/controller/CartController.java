package com.sparta.hh99_clone.controller;

import com.sparta.hh99_clone.domain.Cart;
import com.sparta.hh99_clone.dto.request.CartRequestDto;
import com.sparta.hh99_clone.dto.response.CartResponseDto;
import com.sparta.hh99_clone.dto.response.ItemResponseDto;
import com.sparta.hh99_clone.security.UserDetailsImpl;
import com.sparta.hh99_clone.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // 장바구니 상품 담기
    @PostMapping("/api/cart/add")
    public void saveCart(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CartRequestDto cartRequestDto) {
        cartService.saveCart(userDetails, cartRequestDto);
    }

//    @GetMapping("/api/cart/add")
//    public List<CartResponseDto> showCart(){
//        return cartService.showCart();
//    }

    // 장바구니안에 상품 삭제
//    @DeleteMapping("/api/cart/{cartId}/delete")
//    public void deleteCart(@PathVariable Long cartId){
//        cartService.deleteCart(cartId);
//    }

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
