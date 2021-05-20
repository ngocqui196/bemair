package com.codegym.airbnbbemair.demo.repository;


import com.codegym.airbnbbemair.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
