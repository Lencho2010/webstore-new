package com.geoway.webstore.listener;

import com.geoway.webstore.event.PayCompletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Lencho
 * @create 2021-09-05 22:17
 * @desc
 */

@Component
public class PayCompletedListener {
    private static final Map<Long, SseEmitter> sseEmitters = new Hashtable<>();

    public void addSseEmitters(Long payRecordId, SseEmitter sseEmitter) {
        sseEmitters.put(payRecordId, sseEmitter);
    }

    @EventListener
    public void deployEventHandler(PayCompletedEvent payCompletedEvent) throws IOException {
        Long payRecordId = payCompletedEvent.getPayRecordId();
        SseEmitter sseEmitter = sseEmitters.get(payRecordId);
        sseEmitter.send("支付成功");
        sseEmitter.complete();

    }
}

