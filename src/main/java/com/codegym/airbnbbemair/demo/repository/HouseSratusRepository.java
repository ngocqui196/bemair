package com.codegym.airbnbbemair.demo.repository;

import com.codegym.airbnbbemair.demo.model.HouseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseSratusRepository extends JpaRepository<HouseStatus, Long> {
}
