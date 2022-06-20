package com.sparta.hh99_clone.controller;

import com.sparta.hh99_clone.dto.request.CartRequestDto;
import com.sparta.hh99_clone.dto.response.CartResponseDto;
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

    // Cart 조회
    @GetMapping("/api/cart")
    public List<CartResponseDto> showCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return cartService.showCart(userDetails);
    }

    // Cart Item 추가
    @PostMapping("/api/cart/add")
    public void saveItem(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CartRequestDto requestDto) {
        cartService.saveItem(userDetails, requestDto);
    }

    // Cart Item 삭제
    @DeleteMapping("/api/cart/{cartItemId}/delete")
    public void deleteItem(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long cartItemId) {
        cartService.deleteItem(userDetails, cartItemId);
    }
}
