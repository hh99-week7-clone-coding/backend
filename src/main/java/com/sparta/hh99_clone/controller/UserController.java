package com.sparta.hh99_clone.controller;

import com.sparta.hh99_clone.dto.request.UserSignupRequestDto;
import com.sparta.hh99_clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 회원가입
    @PostMapping("/api/user/signup")
    public void userSignup(@Valid @RequestBody UserSignupRequestDto requestDto) {
        userService.userSignup(requestDto);
    }

    // 로그인 테스트 (백엔드용)
    @PostMapping("/api/user/test")
    public String test() {
        return "Login Successful.";
    }
}
