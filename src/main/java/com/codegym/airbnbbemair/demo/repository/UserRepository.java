package com.codegym.airbnbbemair.demo.repository;


import com.codegym.airbnbbemair.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUsername(String userName);

    @Query(value = "SELECT email from  bemair.user where email = ?1", nativeQuery = true)
    String existsByEmail(String username);

    User findUserByEmail(String email);

}
