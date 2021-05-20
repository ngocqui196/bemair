package com.codegym.airbnbbemair.demo.repository;

import com.codegym.airbnbbemair.demo.model.TypeHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeHouseRepository extends JpaRepository<TypeHouse, Long> {
}
