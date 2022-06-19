package com.sparta.hh99_clone.service;

import com.sparta.hh99_clone.domain.Cart;
import com.sparta.hh99_clone.domain.CartItem;
import com.sparta.hh99_clone.domain.Item;
import com.sparta.hh99_clone.domain.User;
import com.sparta.hh99_clone.dto.request.CartRequestDto;
import com.sparta.hh99_clone.dto.response.CartResponseDto;
import com.sparta.hh99_clone.repository.CartRepository;
import com.sparta.hh99_clone.repository.ItemRepository;
import com.sparta.hh99_clone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public String postCart(CartRequestDto cartRequestDto, Long userId, List<CartItem> cartItem){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없습니다.")
        );

        //아이템리스트를 저장하자

        CartResponseDto cartResponseDto = new CartResponseDto();
        return "카트저장 완료";
    }


    //장바구니 상품 조회
    @Transactional
    public List<CartResponseDto> getCart(Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("찾는 유저가 없습니다.")
        );
        if(user.isPresent())





        return cartResponseDtos;
    }


    // 장바구니 상품 삭제
    @Transactional
    public ResponseEntity deleteCart(Long userId, Long cartItemId){
        // 유저가 존재하는지 유저 리포지토리에서 찾음 없다면 에러 반환
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("찾는 유저가 없습니다.")
        );

        //장바구니 안에 저장되어있는 id가 있는지 확인 없으면 에러 반환
        Cart cart = cartRepository.findById(cartItemId).orElseThrow(
                () -> new IllegalArgumentException("저장된 상품이 없습니다.")
        );

        //있다면 리포지토리에서 itemId 를 삭제
        cartRepository.deleteById(cartItemId);
        return new ResponseEntity("삭제되었습니다.", HttpStatus.OK);
    }



}
