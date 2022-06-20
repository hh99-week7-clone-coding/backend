package com.sparta.hh99_clone.repository;

import com.sparta.hh99_clone.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
public interface UserRepository extends JpaRepository<User, Long> {
=======
import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findByUsername(String username);
>>>>>>> Han
}
