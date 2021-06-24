package com.example.jpa.web.service;

import com.example.jpa.web.dto.request.LoginRequest;
import com.example.jpa.common.model.entity.LoginHistory;
import com.example.jpa.common.model.entity.User;
import com.example.jpa.common.model.repository.LoginHistoryRepository;
import com.example.jpa.common.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AllArgsConstructor
@Service
public class LoginService {

    private final UserRepository userRepository;

    private final LoginHistoryRepository loginHistoryRepository;

    private final PointService pointService;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public boolean login(LoginRequest loginRequest) {

        boolean result = false;
        User user = userRepository.findByEmail(loginRequest.getEmail());

        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

            pointService.storeLoginPoint(user);

            LoginHistory loginHistory = new LoginHistory(user, loginRequest.getIp());
            LoginHistory saveLoginHistory = loginHistoryRepository.save(loginHistory);

            user.setLastLogin(saveLoginHistory.getCreatedAt());

            result = true;
        }

        return result;
    }
}
