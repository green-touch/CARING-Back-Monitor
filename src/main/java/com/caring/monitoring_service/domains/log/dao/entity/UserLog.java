package com.caring.monitoring_service.domains.log.dao.entity;

import com.caring.monitoring_service.common.auditing.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Document(collection = "user_log")
public class UserLog extends BaseTimeEntity {
    @Id
    private String id;
    private String userUuid;
    private String message;
//    private Instant timestamp;
}
