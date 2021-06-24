package com.example.jpa.web.service;

import com.example.jpa.web.common.event.RegisteredEvent;
import com.example.jpa.web.dto.request.RegisterRequest;
import com.example.jpa.common.model.entity.User;
import com.example.jpa.common.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@AllArgsConstructor
@Service
public class RegisterService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public boolean register(RegisterRequest registerRequest) {

        registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        User user = registerRequest.toEntity();
        User saveUser = userRepository.save(user);

        log.info("======== register complete ========");

        applicationEventPublisher.publishEvent(new RegisteredEvent(user.getEmail(), user.getName()));

        return true;
    }
}
