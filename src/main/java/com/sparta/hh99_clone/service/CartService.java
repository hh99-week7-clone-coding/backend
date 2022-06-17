package com.sparta.hh99_clone.service;

import com.sparta.hh99_clone.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;



}
