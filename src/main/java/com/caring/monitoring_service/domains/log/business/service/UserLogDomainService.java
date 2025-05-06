package com.caring.monitoring_service.domains.log.business.service;

import com.caring.monitoring_service.presentation.log.vo.RequestUserLog;

public interface UserLogDomainService {
    String saveLog(RequestUserLog requestUserLog);
}
