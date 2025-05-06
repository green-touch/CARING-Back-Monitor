package com.caring.monitoring_service.domains.log.business.service;

import com.caring.monitoring_service.common.annotation.DomainService;
import com.caring.monitoring_service.domains.log.dao.entity.UserLog;
import com.caring.monitoring_service.domains.log.dao.repository.UserLogRepository;
import com.caring.monitoring_service.presentation.log.vo.RequestUserLog;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class UserLogDomainServiceImpl implements UserLogDomainService {

    private final UserLogRepository userLogRepository;

    @Override
    public String saveLog(RequestUserLog requestUserLog) {
        UserLog userLog = UserLog.builder()
                .userUuid(requestUserLog.getUserUuid())
                .message(requestUserLog.getMessage())
                .build();
        return userLogRepository.save(userLog).getId();
    }
}
