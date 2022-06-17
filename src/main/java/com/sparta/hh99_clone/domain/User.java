package com.sparta.hh99_clone.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
