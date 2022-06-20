package com.sparta.hh99_clone.service;

import com.sparta.hh99_clone.domain.Cart;
import com.sparta.hh99_clone.domain.CartItem;
import com.sparta.hh99_clone.domain.Item;
import com.sparta.hh99_clone.domain.User;
import com.sparta.hh99_clone.dto.request.CartRequestDto;
import com.sparta.hh99_clone.dto.response.CartResponseDto;
import com.sparta.hh99_clone.dto.response.ItemResponseDto;
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
    public void saveCart(CartRequestDto cartRequestDto, Long itemId, User userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없습니다.")
        );

        // 장바구니 내 주문 수량
        int quantity = cartRequestDto.getQuantity();
        System.out.println(quantity);

        Item item = itemRepository.findById(itemId).orElseThrow(
                () -> new IllegalArgumentException("제품이 존재하지 않습니다.")
        );

        // 장바구니 제품 수량 유효성 검사
        if (quantity == 0) {
            throw new IllegalArgumentException("장바구니에 담을 갯수를 정해주세요.");
        }

        List<Cart> cartCheck = cartRepository.findAllByitemId(itemId);

        if (cartCheck.size() > 0) {
            //이미 동일한 제품을 담은 경우 수량이 더해짐
            for (Cart carts : cartCheck) {
                carts.setQuantity(carts.getQuantity() + quantity);
                cartRepository.save(carts);
            }
        } else {
            Cart cart = new Cart(user, itemId, quantity);
            cartRepository.save(cart);
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
    public void deleteCart(Long userId, Long itemId) {
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


//장바구니 상품 조회
//    @Transactional
//    public List<CartResponseDto> getCart(Long userId){
//        User user = userRepository.findById(userId).orElseThrow(
//                () -> new IllegalArgumentException("찾는 유저가 없습니다.")
//        );
//        if(user.isPresent())
//
//
//
//
//
//        return cartResponseDtos;
//    }