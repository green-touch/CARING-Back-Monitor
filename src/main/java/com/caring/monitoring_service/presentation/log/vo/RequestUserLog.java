package com.caring.monitoring_service.presentation.log.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class RequestUserLog {
    private final String id;
    private final String userUuid;
    private final String message;

//    @JsonCreator
//    public RequestUserLog(
//            @JsonProperty("id") String id,
//            @JsonProperty("userUuid") String userUuid,
//            @JsonProperty("message") String message
//    ) {
//        this.id = id;
//        this.userUuid = userUuid;
//        this.message = message;
//    }
}
