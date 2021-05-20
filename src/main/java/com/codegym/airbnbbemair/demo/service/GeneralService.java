package com.codegym.airbnbbemair.demo.service;


import com.codegym.airbnbbemair.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T> {
    List<T> findAll();

    T save(T t);

    T findById(Long id);

    void remove(T t);
}
