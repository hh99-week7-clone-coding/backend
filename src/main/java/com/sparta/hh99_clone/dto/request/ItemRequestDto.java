package com.sparta.hh99_clone.dto.request;


import lombok.Getter;

@Getter
public class ItemRequestDto {   // response test용 임시 작성 //POST할때 필요해

    private String itemName;
    private String imageUrl;
    private int price;
    private String description;

}
