package com.sparta.hh99_clone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Hh99CloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hh99CloneApplication.class, args);
    }

}
