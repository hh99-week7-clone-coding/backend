package com.sparta.hh99_clone.service;

import com.sparta.hh99_clone.domain.Cart;
import com.sparta.hh99_clone.domain.Item;
import com.sparta.hh99_clone.domain.User;
import com.sparta.hh99_clone.dto.request.CartRequestDto;
import com.sparta.hh99_clone.dto.response.CartResponseDto;
import com.sparta.hh99_clone.repository.CartRepository;
import com.sparta.hh99_clone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Transactional
    public CartResponseDto postCart(CartRequestDto cartRequestDto, Long userId, Item item){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("유저의 아이디가 달라 찾을 수 없습니다.")
        );
        //새로운 아이템 배열을 지정함
        List<Item> items = new ArrayList<>();
        //이 배열엔 모델 item 에 있는 값들을 배열로 만들어 넣어 줄 것이다.




        // 아이템 리스트를 만들고 그 아이템 리스트에 보낼 값들을 넣어준다.
        // 그 아이템 리스트를 담아

//        아이템, 퀀티티
//        User user 유저는 확인만하면 되는거
//                Item item
//                        cartRequestDto = quantity 가져오고
//            item id 에 해당하는
//
//        CartResponseDto cartResponseDto = new CartResponseDto(items, quantity);
        return cartResponseDto;
    }

    @Transactional
    public void deleteCart(Long userId, Long cartItemId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("찾는 유저가 없습니다.")
        );

        Cart cart = cartRepository.findById(cartItemId).orElseThrow(
                () -> new IllegalArgumentException("저장된 상품이 없습니다.")
        );

        cartRepository.deleteById(cartItemId);
    }



}
