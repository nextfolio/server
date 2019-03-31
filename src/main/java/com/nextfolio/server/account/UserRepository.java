package com.nextfolio.server.account;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
//    @Query("select u from User u where u.lastName = ?1")
//    List<User> findByLastName(String lastName);

    Optional<User> findByUsername(String username);

    @Override
    Optional<User> findById(Long aLong);
}
