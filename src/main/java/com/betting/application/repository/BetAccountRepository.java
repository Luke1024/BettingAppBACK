package com.betting.application.repository;

import com.betting.application.domain.BetAccount;
import org.springframework.data.repository.CrudRepository;

public interface BetAccountRepository extends CrudRepository<BetAccount, Long> {
}
