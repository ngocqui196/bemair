package com.codegym.airbnbbemair.demo.service.impl;

import com.codegym.airbnbbemair.demo.model.TypeHouse;
import com.codegym.airbnbbemair.demo.model.User;
import com.codegym.airbnbbemair.demo.repository.TypeHouseRepository;
import com.codegym.airbnbbemair.demo.service.TypeHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeHouseServiceImpl implements TypeHouseService{

    @Autowired
    private TypeHouseRepository typeHouseRepository;
    @Override
    public List<TypeHouse> findAll() {
        return typeHouseRepository.findAll();
    }

    @Override
    public TypeHouse save(TypeHouse typeHouse) {
        return null;
    }

    @Override
    public TypeHouse findById(Long id) {
        return null;
    }

    @Override
    public void remove(TypeHouse typeHouse) {
    }
}
