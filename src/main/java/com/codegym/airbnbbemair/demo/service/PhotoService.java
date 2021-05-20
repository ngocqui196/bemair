package com.codegym.airbnbbemair.demo.service;

import com.codegym.airbnbbemair.demo.model.Photo;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public interface PhotoService extends GeneralService<Photo> {
    void saveAll(List<Photo> photos);
}
