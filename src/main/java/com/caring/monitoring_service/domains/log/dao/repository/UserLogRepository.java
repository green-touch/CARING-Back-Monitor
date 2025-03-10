package com.caring.monitoring_service.domains.log.dao.repository;

import com.caring.monitoring_service.domains.log.dao.entity.UserLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserLogRepository extends MongoRepository<UserLog, String> {
    List<UserLog> findByUserUuid(String userUuid);
}
