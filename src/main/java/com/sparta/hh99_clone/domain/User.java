package com.sparta.hh99_clone.domain;

import com.sparta.hh99_clone.dto.request.UserSignupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String nation;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    public User(UserSignupRequestDto requestDto) {
        this.nation = requestDto.getNation();
        this.firstName = requestDto.getFirstName();
        this.lastName = requestDto.getLastName();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
    }
}
