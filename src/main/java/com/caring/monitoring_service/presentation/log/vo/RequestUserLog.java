package com.caring.monitoring_service.presentation.log.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RequestUserLog {
    private String id;
    private String userUuid;
    private String message;
}
