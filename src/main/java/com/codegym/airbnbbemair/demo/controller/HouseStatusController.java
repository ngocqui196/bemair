package com.codegym.airbnbbemair.demo.controller;

import com.codegym.airbnbbemair.demo.model.HouseStatus;
import com.codegym.airbnbbemair.demo.service.HouseService;
import com.codegym.airbnbbemair.demo.service.HouseStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houseStatus")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HouseStatusController {

    @Autowired
    private HouseStatusService houseStatusService;
    @GetMapping("")
    public ResponseEntity<List<HouseStatus>> showListAllHouseStatus() {
        List<HouseStatus> houseStatuses = houseStatusService.findAll();
        return new ResponseEntity<>(houseStatuses, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createHouseStatus(@RequestBody HouseStatus houseStatus) {
            houseStatusService.save(houseStatus);
            return ResponseEntity.ok(HttpStatus.OK);
    }

}
