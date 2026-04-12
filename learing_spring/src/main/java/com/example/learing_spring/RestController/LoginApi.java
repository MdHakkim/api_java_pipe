package com.example.learing_spring.RestController;

import com.example.learing_spring.Model.Login;
import com.example.learing_spring.Security.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginApi {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtility jwtUtility;

    @PostMapping("login")
    public ResponseEntity<?> signin(@RequestBody Login login) {
        try {

            // Authenticate user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getName(), login.getPassword())
            );

            // Generate JWT token
            String token = jwtUtility.generateToken(login.getName());

            // Return token in response
            return ResponseEntity.ok(Map.of("token", token));
        } catch (Exception ex) {
            // Return 401 Unauthorized if login fails
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid username or password"));
        }
    }

    @GetMapping("/api/index")
    public String indexPage(){
        return "we reach the Landing page of application";
    }
}
