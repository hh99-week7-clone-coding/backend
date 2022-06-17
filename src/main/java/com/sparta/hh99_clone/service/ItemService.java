package com.sparta.hh99_clone.service;

import com.sparta.hh99_clone.domain.Item;
import com.sparta.hh99_clone.dto.request.ItemRequestDto;
import com.sparta.hh99_clone.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item save(ItemRequestDto itemRequestDto){
        Item item = new Item(itemRequestDto);
        return itemRepository.save(item);
    }

    public List<Item> show(){
        return itemRepository.findAll();
    }

}
