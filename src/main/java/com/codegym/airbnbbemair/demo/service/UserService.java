package com.codegym.airbnbbemair.demo.service;


import com.codegym.airbnbbemair.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService, GeneralService<User> {
    User findByEmail(String email);
    String existsByEmail(String email);
}
