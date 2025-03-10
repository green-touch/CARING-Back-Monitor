package com.caring.monitoring_service.common.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class KafkaLogProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaLogProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLog(String userUuid, String message) {
        String logMessage = String.format("{\"userUuid\":\"%s\",  \"message\":\"%s\"}",
                userUuid, message);

        kafkaTemplate.send("logs-topic", userUuid, logMessage);
        log.info("✅ Log sent: {}", logMessage);
    }
}
