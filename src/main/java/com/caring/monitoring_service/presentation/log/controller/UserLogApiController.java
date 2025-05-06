package com.caring.monitoring_service.presentation.log.controller;

import com.caring.monitoring_service.domains.log.business.service.UserLogDomainService;
import com.caring.monitoring_service.presentation.log.vo.RequestUserLog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/user-log")
@RequiredArgsConstructor
public class UserLogApiController {

    private final UserLogDomainService userLogDomainService;

    @PostMapping
    public String saveLog(@RequestBody RequestUserLog requestUserLog) {
        return userLogDomainService.saveLog(requestUserLog);
    }
}
