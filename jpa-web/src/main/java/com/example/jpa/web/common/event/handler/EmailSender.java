package com.example.jpa.web.common.event.handler;

import com.example.jpa.web.common.event.RegisteredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailSender {

    @EventListener
    public void registerdEventHandler(RegisteredEvent event) {

        log.info("회원가입 이메일 발송");
    }
}
