package com.example.jpa.common.model.repository;

import com.example.jpa.common.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String string);
}
