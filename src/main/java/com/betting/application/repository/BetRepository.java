package com.betting.application.repository;

import com.betting.application.domain.Bet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {

}
