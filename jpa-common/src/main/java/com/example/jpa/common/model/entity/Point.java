package com.example.jpa.common.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "point")
public class Point {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "point")
    private Integer point;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public Point(User user, int point) {
        this.user = user;
        this.point = point;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", user=" + user +
                ", point=" + point +
                ", createdAt=" + createdAt +
                '}';
    }
}
