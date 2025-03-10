package com.caring.monitoring_service.common.service.kafka;

import com.caring.monitoring_service.common.util.StaticVariable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;

import static com.caring.monitoring_service.common.util.StaticVariable.KAFKA_LOG_TOPIC;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaLogProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendLog(String userUuid, String message) {
        HashMap<String, String> logMap = new HashMap<>();
        logMap.put("userUuid", userUuid);
        logMap.put("message", message);

        String logMessage;
        try{
            logMessage = objectMapper.writeValueAsString(logMap);
            kafkaTemplate.send(KAFKA_LOG_TOPIC, userUuid, logMessage);
            log.info("✅ Log sent: {}", logMessage);
        } catch (JsonProcessingException e){
            log.error("❌ JSON 파싱 오류: {}", e.getMessage());
        }
        catch (Exception e) {
            log.error("❌ Failed to process log: {}", e.getMessage());
        }
    }
}
