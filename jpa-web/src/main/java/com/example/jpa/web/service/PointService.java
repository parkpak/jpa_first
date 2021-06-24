package com.example.jpa.web.service;

import com.example.jpa.common.model.entity.Point;
import com.example.jpa.common.model.entity.User;
import com.example.jpa.common.model.repository.PointRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
@AllArgsConstructor
@Service
public class PointService {

    private static final int LOGIN_POINT = 10;

    private static final int POST_CREATE_POINT = 20;
    private static final int POST_DESTROY_POINT = -20;

    private final PointRepository pointRepository;

    /**
     * 로그인 포인트 지급
     * @param user
     */
    @Transactional
    public void storeLoginPoint(User user) {
        if (isOneDayBeforeLogin(user.getLastLogin())) {
            pointRepository.save(new Point(user, LOGIN_POINT));
        }
    }

    /**
     * 24시간 이전 로그인 확인
     * @param lastLogin
     * @return
     */
    private boolean isOneDayBeforeLogin(LocalDateTime lastLogin) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(lastLogin, now);
        long interval = duration.getSeconds();
        log.debug("interval : " + interval);

        return interval > 86400;
    }

    /**
     * 글 등록 포인트 지급
     * @param user
     */
    @Transactional
    public void storePostPoint(User user) {
        pointRepository.save(new Point(user, POST_CREATE_POINT));
    }

    /**
     * 글 삭제 포인트 회수
     * @param user
     */
    @Transactional
    public void destroyPostPoint(User user) {
        pointRepository.save(new Point(user, POST_DESTROY_POINT));
    }
}
