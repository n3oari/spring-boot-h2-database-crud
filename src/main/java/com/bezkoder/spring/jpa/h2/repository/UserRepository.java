package com.bezkoder.spring.jpa.h2.repository;


import com.bezkoder.spring.jpa.h2.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);

    List<Users> findByFullNameContainingIgnoreCase(String fullName);
}