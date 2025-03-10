package com.caring.monitoring_service.domains.log.dao.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "user_log")
public class UserLog {
    @Id
    private String id;
    private String userUuid;
    private String message;
    private Instant timestamp;
}
