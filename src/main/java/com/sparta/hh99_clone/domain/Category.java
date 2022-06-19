package com.sparta.hh99_clone.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

//    private String title;

//    @JsonIgnore
//    @OneToMany(
//            mappedBy = "category",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    ) //category가 주체가 될거다
//    private List<Item> items;




}
