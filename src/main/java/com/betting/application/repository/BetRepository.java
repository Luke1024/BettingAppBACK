package com.betting.application.repository;

import com.betting.application.domain.Bet;
import com.betting.application.domain.dto.BetDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {

}
