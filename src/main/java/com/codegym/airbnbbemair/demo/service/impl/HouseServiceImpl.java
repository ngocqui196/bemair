package com.codegym.airbnbbemair.demo.service.impl;

import com.codegym.airbnbbemair.demo.model.House;
import com.codegym.airbnbbemair.demo.model.User;
import com.codegym.airbnbbemair.demo.repository.HouseRepository;
import com.codegym.airbnbbemair.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository repository;
    @Override
    public List<House> findAll() {
        return repository.findAll();
    }

    @Override
    public House save(House house) {
        return repository.save(house);
    }

    @Override
    public House findById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void remove(House user) {
        repository.delete(user);
    }
}
