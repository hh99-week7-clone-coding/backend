package com.sparta.hh99_clone.service;

import com.sparta.hh99_clone.domain.Cart;
import com.sparta.hh99_clone.domain.CartItem;
import com.sparta.hh99_clone.domain.Item;
import com.sparta.hh99_clone.domain.User;
import com.sparta.hh99_clone.dto.request.CartRequestDto;
import com.sparta.hh99_clone.dto.response.CartResponseDto;
import com.sparta.hh99_clone.repository.CartItemRepository;
import com.sparta.hh99_clone.repository.CartRepository;
import com.sparta.hh99_clone.repository.ItemRepository;
import com.sparta.hh99_clone.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ItemRepository itemRepository;

    // Cart 조회
    public List<CartResponseDto> showCart(UserDetailsImpl userDetails) {
        User user = userDetails.getUser();

        Cart cart = cartRepository.findById(user.getUserId()).orElseThrow( // cartId와 userId는 동일하게 세팅되어 있습니다.
                () -> new NullPointerException("카트가 존재하지 않습니다.")
        );

        List<CartItem> cartItems = cart.getCartItems();
        List<CartResponseDto> cartResponseDtos = new ArrayList<>();

        for(int i = 0; i < cartItems.size(); i++) {
            Long itemId = cartItems.get(i).getItemId();
            int quantity = cartItems.get(i).getQuantity();
            Item item = itemRepository.findById(itemId).orElseThrow(
                    () -> new NullPointerException("제품이 존재하지 않습니다.")
            );
            CartResponseDto newDto = new CartResponseDto(item, quantity);
            cartResponseDtos.add(newDto);
        }
        return cartResponseDtos;
    }

    // Cart Item 추가
    @Transactional
    public void saveItem(UserDetailsImpl userDetails, @RequestBody CartRequestDto requestDto) {
        User user = userDetails.getUser();
        int quantity = requestDto.getQuantity();

        Item item = itemRepository.findById(requestDto.getItemId()).orElseThrow(
                () -> new IllegalArgumentException("제품이 존재하지 않습니다.")
        );

        if (quantity == 0) {
            throw new IllegalArgumentException("장바구니에 담을 갯수를 정해주세요.");
        }

        Cart cart = cartRepository.findById(user.getUserId()).orElseThrow( // cartId와 userId는 동일하게 세팅되어 있습니다.
                () -> new NullPointerException("카트가 존재하지 않습니다.")
        );

        List<CartItem> cartItems = cart.getCartItems();

        int cartItemId = -1;

        for(int i = 0; i < cartItems.size(); i++) {
            if(cartItems.get(i).getItemId() == item.getItemId() ) {
                cartItemId = i;
            }
        }

        if(cartItemId != -1) {
            cartItems.get(cartItemId).setQuantity(cartItems.get(cartItemId).getQuantity() + quantity);
            cartItemRepository.save(cartItems.get(cartItemId));
        } else {
            CartItem newCartItem = new CartItem(user.getUserId(), item.getItemId(), quantity);
            cartItemRepository.save(newCartItem);
        }
    }

    // Cart Item 삭제
    @Transactional
    public void deleteItem(UserDetailsImpl userDetails, Long cartItemId) {
        User user = userDetails.getUser();
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(
                () -> new NullPointerException("카트 아이템이 존재하지 않습니다.")
        );

        if(!Objects.equals(user.getUserId(), cartItem.getUserId())) throw new IllegalArgumentException("로그인한 사용자의 카트 아이템이 아닙니다.");

        cartItemRepository.deleteById(cartItemId);
    }
}