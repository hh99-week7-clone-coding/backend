package com.sparta.hh99_clone.repository;

import com.sparta.hh99_clone.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
