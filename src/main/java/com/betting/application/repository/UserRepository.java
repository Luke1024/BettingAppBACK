package com.betting.application.repository;

import com.betting.application.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query
    List<User> retrieveUserByEmail(@Param("EMAIL")String user_email);

    @Query
    List<User> retrieveUserByPassword(@Param("PASSWORD")String password);
}
