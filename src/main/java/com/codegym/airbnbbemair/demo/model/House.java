package com.codegym.airbnbbemair.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class House {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private String address;
    private Long noBedrooms;
    private Long noBathrooms;
    private String detail;
    private Double price;
    @ManyToOne
    private User user;
    @ManyToOne
    private TypeHouse typeHouse;
    @ManyToOne
    private HouseStatus houseStatus;

    @OneToMany
    private List<Photo> photos;

    public House() {
    }

    public House(String name,
                 User user,
                 TypeHouse typeHouse,
                 HouseStatus houseStatus,
                 String address,
                 Long noBedrooms,
                 Long noBathrooms,
                 String detail,
                 Double price,
                 List<Photo> photos) {
        this.name = name;
        this.user = user;
        this.typeHouse = typeHouse;
        this.houseStatus = houseStatus;
        this.address = address;
        this.noBedrooms = noBedrooms;
        this.noBathrooms = noBathrooms;
        this.detail = detail;
        this.price = price;
        this.photos = photos;
    }

    public House(Long id, String name, TypeHouse typeHouse) {
        this.id = id;
        this.name = name;
        this.typeHouse = typeHouse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeHouse getTypeHouse() {
        return typeHouse;
    }

    public void setTypeHouse(TypeHouse typeHouse) {
        this.typeHouse = typeHouse;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNoBedrooms() {
        return noBedrooms;
    }

    public void setNoBedrooms(Long noBedrooms) {
        this.noBedrooms = noBedrooms;
    }

    public Long getNoBathrooms() {
        return noBathrooms;
    }

    public void setNoBathrooms(Long noBathrooms) {
        this.noBathrooms = noBathrooms;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HouseStatus getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(HouseStatus houseStatus) {
        this.houseStatus = houseStatus;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
