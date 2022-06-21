package com.sparta.hh99_clone.service;

import com.sparta.hh99_clone.domain.Cart;
import com.sparta.hh99_clone.domain.User;
import com.sparta.hh99_clone.dto.request.UserSignupRequestDto;
import com.sparta.hh99_clone.repository.CartRepository;
import com.sparta.hh99_clone.exception.CustomException;
import com.sparta.hh99_clone.exception.ErrorCode;
import com.sparta.hh99_clone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;

    // 회원가입
    @Transactional
    public void userSignup(UserSignupRequestDto requestDto) {
        if (userRepository.findByUsername(requestDto.getUsername()).isPresent()) {
            throw new CustomException(ErrorCode.USER_EMAIL_CONFLICT);
        }
        User user = new User(requestDto);
        String password = passwordEncoder.encode(requestDto.getPassword());
        user.setPassword(password);
        userRepository.save(user);

        Cart cart = new Cart();
        cartRepository.save(cart);
    }
}
