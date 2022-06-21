package com.sparta.hh99_clone.service;

import com.sparta.hh99_clone.domain.Item;

import com.sparta.hh99_clone.dto.response.ItemResponseDto;
import com.sparta.hh99_clone.exception.CustomException;
import com.sparta.hh99_clone.exception.ErrorCode;
import com.sparta.hh99_clone.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    // Item 카테고리 조회
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

    // Item 상세 조회
    public ItemResponseDto getItem(Long itemId) {
        Item item =  itemRepository.findById(itemId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_ITEM)
        );
        return new ItemResponseDto(item);
    }
}
