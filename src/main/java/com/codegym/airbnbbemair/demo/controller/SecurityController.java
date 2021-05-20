package com.codegym.airbnbbemair.demo.controller;

import com.codegym.airbnbbemair.demo.jwt.JwtUtility;
import com.codegym.airbnbbemair.demo.model.Role;
import com.codegym.airbnbbemair.demo.model.User;
import com.codegym.airbnbbemair.demo.model.UserPrinciple;
import com.codegym.airbnbbemair.demo.payload.response.JwtResponse;
import com.codegym.airbnbbemair.demo.payload.response.MessageResponse;
import com.codegym.airbnbbemair.demo.repository.RoleRepository;
import com.codegym.airbnbbemair.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/security")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityController {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

//    @Autowired
//    private PasswordEncoder encoder;

    @Autowired
    private RoleRepository roleRepository;

//    @Autowired
//    private RoleService roleService;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtility.generateJwtToken(user.getEmail());
        UserPrinciple userDetails = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

//        User account = userService.findByEmail();

        return ResponseEntity.ok(
                new JwtResponse(
                        jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        roles
                )
        );
    }


    @PostMapping(value = "/register")
    public ResponseEntity<MessageResponse> CreateUser(@RequestBody User user) {
        String username = userService.existsByEmail(user.getEmail());
        if (username != null && username.equals(user.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Tài khoản đã tồn tại!!!"));
        } else {
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

}
