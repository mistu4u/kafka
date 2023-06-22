package com.example.kafkastreams.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class Producer {
    @Value("${kafka.input.topic}")
    private String topic;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedRate = 30 * 1000)
    public void sendMessage() {
        String key = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String message = "hello topic " + key;
        kafkaTemplate.send(topic, key, message);
        log.info("{} message sent to topic {} at time {}", message, topic, LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}
