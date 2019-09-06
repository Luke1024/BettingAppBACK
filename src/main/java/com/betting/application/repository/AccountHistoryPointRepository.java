package com.betting.application.repository;

import com.betting.application.domain.AccountHistoryPoint;
import org.springframework.data.repository.CrudRepository;

public interface AccountHistoryPointRepository extends CrudRepository<AccountHistoryPoint, Long> {
}
