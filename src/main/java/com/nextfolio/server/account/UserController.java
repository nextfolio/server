package com.nextfolio.server.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController("user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public User register(@RequestBody User user) {
        System.out.println("Hello");
        // Create user in database
        List<User> users = repository.findByUsername(user.getUsername());
        if (users.isEmpty()) {
            user = repository.save(user);
            return user;
        }

        throw new ResponseStatusException(HttpStatus.CONFLICT, "Account already exists");
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void login(@RequestBody User user) {

    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public void logout(@RequestBody User user) {

    }
}
