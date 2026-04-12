package com.example.learing_spring.Services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    public List<String> getHome(){
        return List.of("home","dine","dinner");
    }
}
