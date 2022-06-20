package com.sparta.hh99_clone.repository;

import com.sparta.hh99_clone.domain.Solar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SolarRepository extends JpaRepository<Solar, Long> {

    Optional<Solar> findBySolarId(Long solarId);
}
