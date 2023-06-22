package com.example.kafkastreams.processor;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StreamsProcessor {
    @Value("${kafka.input.topic}")
    private String inputTopic;
    @Value("${kafka.output.topic}")
    private String outputTopic;

    @Autowired
    private StreamsBuilder streamsBuilder;

    @PostConstruct
    public void process() {
        KStream<String, String> kStream =
                streamsBuilder.stream(inputTopic, Consumed.with(Serdes.String(), Serdes.String()));
        kStream.filter((k, v) -> v.startsWith("hello")).mapValues((k, v) -> v.toUpperCase())
                .peek((k, v) -> log.info("processed key {} and value {}", k, v)).to(outputTopic, Produced.with(Serdes.String(), Serdes.String()));
    }
}
