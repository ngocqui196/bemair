package com.codegym.airbnbbemair.demo.controller;

import com.codegym.airbnbbemair.demo.model.House;
import com.codegym.airbnbbemair.demo.model.Photo;
import com.codegym.airbnbbemair.demo.service.HouseService;
import com.codegym.airbnbbemair.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/house")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private PhotoService photoService;

    @GetMapping("")
    public ResponseEntity<List<House>> findAllHouse() {
        List<House> houses = houseService.findAll();
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createhouse(@RequestBody House house) {
        List<Photo> photos = house.getPhotos();
        photoService.saveAll(photos);
        houseService.save(house);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
