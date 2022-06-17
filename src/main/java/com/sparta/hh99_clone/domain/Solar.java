package com.sparta.hh99_clone.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class Solar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long solarId;

    @Column
    private String solarName;
}
