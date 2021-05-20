package com.codegym.airbnbbemair.demo.service.impl;


import com.codegym.airbnbbemair.demo.model.Role;
import com.codegym.airbnbbemair.demo.model.User;
import com.codegym.airbnbbemair.demo.model.UserPrinciple;
import com.codegym.airbnbbemair.demo.repository.RoleRepository;
import com.codegym.airbnbbemair.demo.repository.UserRepository;
import com.codegym.airbnbbemair.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        Role role = roleRepository.getOne(1L);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void remove(User user) {
        userRepository.delete(user);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User account = userRepository.findUserByEmail(email);
        if(account==null){
            throw new UsernameNotFoundException("User " + email + " was not found in the database");
        }
        return UserPrinciple.build(account);
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public String existsByEmail(String username) {
        return userRepository.existsByEmail(username);
    }
}
