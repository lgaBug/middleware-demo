package com.lga.spring;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class PaidEvent extends ApplicationEvent {

    private String orderId;

    private String userId;

    public PaidEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "PaidEvent{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
