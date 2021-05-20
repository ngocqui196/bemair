package com.codegym.airbnbbemair.demo.service.impl;

import com.codegym.airbnbbemair.demo.model.HouseStatus;
import com.codegym.airbnbbemair.demo.repository.HouseSratusRepository;
import com.codegym.airbnbbemair.demo.service.HouseStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseStatusServiceImpl implements HouseStatusService {
    @Autowired
    private HouseSratusRepository repository;
    @Override
    public List<HouseStatus> findAll() {
        return repository.findAll();
    }

    @Override
    public HouseStatus save(HouseStatus houseStatus) {
        return null;
    }

    @Override
    public HouseStatus findById(Long id) {
        return null;
    }

    @Override
    public void remove(HouseStatus houseStatus) {

    }
}
