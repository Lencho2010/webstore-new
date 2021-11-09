package com.geoway.webstore.event;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author Lencho
 * @create 2021-09-05 22:15
 * @desc
 */
@Getter
@Setter
public class PayCompletedEvent extends ApplicationEvent {
    private Long payRecordId;

    public PayCompletedEvent(Object source, Long payRecordId) {
        super(source);
        this.payRecordId = payRecordId;
    }
}

