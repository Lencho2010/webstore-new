package com.geoway.webstore.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Lencho
 * @create 2021-09-05 20:40
 * @desc
 */
@Slf4j
public class SseEmitters {
    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    public SseEmitter add() {
        return add(new SseEmitter(-1L));
    }

    public SseEmitter add(SseEmitter emitter) {
        this.emitters.add(emitter);

        emitter.onCompletion(() -> {
            log.info("Emitter completed: {}", emitter);
            this.emitters.remove(emitter);
        });
        emitter.onTimeout(() -> {
            log.info("Emitter timed out: {}", emitter);
            emitter.complete();
            this.emitters.remove(emitter);
        });

        return emitter;
    }

    public void send(Object obj) {
        send(emitter -> emitter.send(obj));
    }

    public void send(SseEmitter.SseEventBuilder builder) {
        send(emitter -> emitter.send(builder));
    }

    private void send(SseEmitterConsumer<SseEmitter> consumer) {
        List<SseEmitter> failedEmitters = new ArrayList<>();

        this.emitters.forEach(emitter -> {
            try {
                consumer.accept(emitter);
            } catch (Exception e) {
                emitter.completeWithError(e);
                failedEmitters.add(emitter);
                log.error("Emitter failed: {}", emitter, e);
            }
        });

        this.emitters.removeAll(failedEmitters);
    }

    @FunctionalInterface
    private interface SseEmitterConsumer<T> {

        void accept(T t) throws IOException;
    }
}
