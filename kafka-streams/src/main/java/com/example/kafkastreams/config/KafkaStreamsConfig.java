package com.example.kafkastreams.config;

import org.apache.kafka.streams.StreamsConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaStreamsConfig {

    @Bean
    public StreamsConfig getStreamsConfig(KafkaProperties kafkaProperties) {
        return new StreamsConfig(kafkaProperties.buildStreamsProperties());
    }
}
