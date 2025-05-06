package com.caring.monitoring_service.domains.log.business.service;

import com.caring.monitoring_service.common.annotation.DomainService;
import com.caring.monitoring_service.domains.log.dao.repository.UserLogRepository;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class UserLogDomainServiceImpl implements UserLogDomainService {
    private final UserLogRepository userLogRepository;
    @Override
    public String saveLog(RequestLogDto requestLogDto) {
        return "";
    }
}
