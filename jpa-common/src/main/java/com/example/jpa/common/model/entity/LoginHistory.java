package com.example.jpa.common.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "login_history")
public class LoginHistory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "ip")
    private String ip;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public LoginHistory(User user, String ip) {
        this.user = user;
        this.ip = ip;
    }
}
