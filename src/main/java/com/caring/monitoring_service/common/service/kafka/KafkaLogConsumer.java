package com.caring.monitoring_service.common.service.kafka;

import com.caring.monitoring_service.domains.log.dao.entity.UserLog;
import com.caring.monitoring_service.domains.log.dao.repository.UserLogRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class KafkaLogConsumer {

    private final UserLogRepository userLogRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaLogConsumer(UserLogRepository userLogRepository) {
        this.userLogRepository = userLogRepository;
    }

    /**
     * consumer의 개수는 yml로 정하는 것이 아닌, 서버 인스턴스의 개수로 설정 가능
     * @param record
     */
    @KafkaListener(topics = "logs-topic", groupId = "log-consumer-group")
    public void consume(ConsumerRecord<String, String> record) {
        try {
            JsonNode logJson = objectMapper.readTree(record.value());
            String userUuid = logJson.get("userUuid").asText();
            String message = logJson.get("message").asText();

            userLogRepository.save(UserLog.builder()
                    .userUuid(userUuid)
                    .message(message)
                    .build());
            log.info("✅ Log saved to MongoDB: {}", record.value());

        } catch (Exception e) {
            log.error("❌ Failed to process log: {}", e.getMessage());
        }
    }
}
