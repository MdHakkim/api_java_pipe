package com.example.learing_spring.Respository;

import com.example.learing_spring.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRep extends JpaRepository<Login,Integer> {
    Optional<Login> findByName(String name);
}
