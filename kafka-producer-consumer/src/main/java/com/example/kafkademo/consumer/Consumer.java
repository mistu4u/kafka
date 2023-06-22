package com.example.kafkademo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {
    @KafkaListener(topics = "${kafka.topic}",
            groupId = "${kafka.groupId}")
    public void consume(String message) {
        log.info("message received = {}", message);
    }
}
