package com.sparta.hh99_clone.service;

import com.sparta.hh99_clone.domain.Cart;
import com.sparta.hh99_clone.domain.CartItem;
import com.sparta.hh99_clone.domain.Item;
import com.sparta.hh99_clone.domain.User;
import com.sparta.hh99_clone.dto.request.CartRequestDto;
import com.sparta.hh99_clone.dto.response.CartResponseDto;
import com.sparta.hh99_clone.dto.response.ItemResponseDto;
import com.sparta.hh99_clone.repository.CartItemRepository;
import com.sparta.hh99_clone.repository.CartRepository;
import com.sparta.hh99_clone.repository.ItemRepository;
import com.sparta.hh99_clone.repository.UserRepository;
import com.sparta.hh99_clone.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
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
    private final CartItemRepository cartItemRepository;

    @Transactional
    public void saveCart(UserDetailsImpl userDetails, CartRequestDto cartRequestDto) {

        User user = userDetails.getUser();

        int quantity = cartRequestDto.getQuantity();
        System.out.println(quantity);

        Item item = itemRepository.findById(cartRequestDto.getItemId()).orElseThrow(
                () -> new IllegalArgumentException("제품이 존재하지 않습니다.")
        );

        Cart cart = cartRepository.findById(user.getUserId()).orElseThrow(
                () -> new NullPointerException("카트가 존재하지 않습니다.")
        );

        List<CartItem> cartItems = cart.getCartItems();

        int CartItemNumber = -1;

        for(int i = 0; i < cartItems.size(); i++){
            if(cartItems.get(i).getItemId() == item.getItemId()){
                CartItemNumber++;
            }
        }

        if(CartItemNumber != -1){
            cartItems.get(CartItemNumber).setQuantity(cartItems.get(i).getQuantity() + quantity);
            cartItemRepository.save(cartItems.get(cartItemId));
        } else {

        }
    }

    // 장바구니 상품 조회
    public List<CartResponseDto> showCart(){
        //cartResponseDto 에 itemName, lowerCategory, imageUrl, price, quantity 를 넣어줘야됨
        List<CartResponseDto> cartResponseDtoList = new ArrayList<>();

        List<Cart> cartList = cartRepository.findAllByuserId(userId);
        for (Cart cart : cartList) {
            // itemId 를 이용, 제품 찾기
            Long itemId = cartList.getItemId();
            Item item = itemRepository.findById((itemId)).orElseThrow(
                    () -> new IllegalArgumentException("상품을 찾을 수 없습니다.")
            );

            ItemResponseDto itemResponseDto = new ItemResponseDto(item);

            // 수량
            int quantity = cart.getQuantity();

            CartResponseDto cartResponseDto = new CartResponseDto(itemId, itemResponseDto, quantity);
            cartResponseDtoList.add(cartResponseDto);
        }
        return cartResponseDtoList;
    }



    // 장바구니 상품 삭제
    public void deleteCart(Long itemId) {
        // 유저가 존재하는지 유저 리포지토리에서 찾음 없다면 에러 반환
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("찾는 유저가 없습니다.")
        );

        //장바구니 안에 저장되어있는 id가 있는지 확인 없으면 에러 반환
        Cart cart = cartRepository.findById(itemId).orElseThrow(
                () -> new IllegalArgumentException("저장된 상품이 없습니다.")
        );

        //있다면 리포지토리에서 itemId 를 삭제
        cartRepository.deleteById(itemId);
    }
}