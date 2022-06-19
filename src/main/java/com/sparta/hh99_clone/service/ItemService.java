package com.sparta.hh99_clone.service;

import com.sparta.hh99_clone.domain.Item;
import com.sparta.hh99_clone.dto.request.ItemRequestDto;
import com.sparta.hh99_clone.dto.response.ItemResponseDto;
import com.sparta.hh99_clone.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;


    //GetMapping 상품 상세 정보 확인 TEST용 PostMapping
//    @Transactional
//    public Item addItem(ItemRequestDto itemRequestDto) {
//        Item item = new Item(itemRequestDto);
//        itemRepository.save(item);
//        return item;
//    }

    // item 상세 정보 확인?
    public ItemResponseDto getItem(Long itemId) {
        Item item =  itemRepository.findById(itemId).orElseThrow(
                () -> new IllegalArgumentException("상품 없음")
        );
        return new ItemResponseDto(item);

    }

    // item 목록
    @Transactional
    public List<ItemResponseDto> getItems(String categoryId) {
        List<ItemResponseDto> itemResponseDtoList =  new ArrayList<>();
        List<Item> items = itemRepository.findAllByCategoryId(categoryId);
        for(int i = 0; i < items.size(); i++) {
            ItemResponseDto itemResponseDto = new ItemResponseDto(items.get(i)); //Dto 로 변환하기 위해 가져온 값
            itemResponseDtoList.add(itemResponseDto);
        }
        return itemResponseDtoList;
    }

}
