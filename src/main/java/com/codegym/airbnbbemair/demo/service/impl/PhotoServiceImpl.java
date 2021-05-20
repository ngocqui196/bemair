package com.codegym.airbnbbemair.demo.service.impl;

import com.codegym.airbnbbemair.demo.model.Photo;
import com.codegym.airbnbbemair.demo.repository.PhotoRepository;
import com.codegym.airbnbbemair.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository repository;

    @Override
    public List<Photo> findAll() {
        return repository.findAll();
    }

    @Override
    public Photo save(Photo photo) {
        return repository.save(photo);
    }

    @Override
    public Photo findById(Long id) {
        return null;
    }

    @Override
    public void remove(Photo photo) {
    }

    public void saveAll(List<Photo> photos) {
        repository.saveAll(photos);
    }
}
