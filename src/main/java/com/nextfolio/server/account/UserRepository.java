package com.nextfolio.server.account;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
//    @Query("select u from User u where u.lastName = ?1")
//    List<User> findByLastName(String lastName);

    List<User> findByUsername(String username);


}
