package com.caring.monitoring_service.common.service.kafka;

import com.caring.monitoring_service.common.util.StaticVariable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static com.caring.monitoring_service.common.util.StaticVariable.KAFKA_LOG_TOPIC;

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

        kafkaTemplate.send(KAFKA_LOG_TOPIC, userUuid, logMessage);
        log.info("✅ Log sent: {}", logMessage);
    }
}
