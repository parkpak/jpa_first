package com.example.jpa.common.model.repository;

import com.example.jpa.common.model.entity.Point;
import com.example.jpa.common.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointRepository extends JpaRepository<Point, Long> {

    List<Point> findPointByUser(User user);
}
