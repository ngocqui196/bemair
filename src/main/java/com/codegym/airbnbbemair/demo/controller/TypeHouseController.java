package com.codegym.airbnbbemair.demo.controller;

import com.codegym.airbnbbemair.demo.model.TypeHouse;
import com.codegym.airbnbbemair.demo.service.TypeHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/typeHouse")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TypeHouseController {

    @Autowired
    private TypeHouseService typeHouseService;

    @GetMapping("")
    public ResponseEntity<List<TypeHouse>> showListAllTypeHouse() {
        List<TypeHouse> typeHouses = typeHouseService.findAll();
        return new ResponseEntity(typeHouses, HttpStatus.OK);
    }
}
