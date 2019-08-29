package com.betting.application.repository;

import com.betting.application.domain.SportEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportEventRepository extends CrudRepository<SportEvent, Long> {

    @Override
    List<SportEvent> findAll();
}
