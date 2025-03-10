package com.caring.monitoring_service.common.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic logsTopic() {
        return new NewTopic("logs-topic", 3, (short) 1);  // 3개의 파티션, 복제 1개
    }
}
