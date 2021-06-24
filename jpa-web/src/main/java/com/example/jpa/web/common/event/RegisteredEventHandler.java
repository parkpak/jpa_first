package com.example.jpa.web.common.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RegisteredEventHandler {

    @EventListener
    public void sendSms(RegisteredEvent event) {
        System.out.println(event.getName() + "님에게 가입 축하 메세지를 전송했습니다");
    }

    @EventListener
    public void makeCoupon(RegisteredEvent event) {
        System.out.println(event.getName() + "님에게 쿠폰을 전송했습니다");
    }
}
