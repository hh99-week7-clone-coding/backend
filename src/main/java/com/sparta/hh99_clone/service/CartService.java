package com.sparta.hh99_clone.service;

import com.sparta.hh99_clone.domain.Item;
import com.sparta.hh99_clone.dto.request.CartRequestDto;
import com.sparta.hh99_clone.dto.response.CartResponseDto;
import com.sparta.hh99_clone.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public CartResponseDto postCart(CartRequestDto cartRequestDto, Long userId, Item item){
        아이템, 퀀티티
        User user 유저는 확인만하면 되는거
                Item item
                        cartRequestDto = quantity 가져오고
            item id 에 해당하는

        CartResponseDto cartResponseDto = new CartResponseDto(items, quantity);
        return cartResponseDto;
    }



}
