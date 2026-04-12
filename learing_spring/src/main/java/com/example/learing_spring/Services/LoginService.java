package com.example.learing_spring.Services;

import com.example.learing_spring.Model.Login;
import com.example.learing_spring.Respository.LoginRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    LoginRep loginRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRep.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                login.getName(),
                login.getPassword(),
                new ArrayList<>()
        );
    }


}
