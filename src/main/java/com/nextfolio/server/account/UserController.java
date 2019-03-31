package com.nextfolio.server.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController("user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public User register(@RequestBody User user) {
        System.out.println("Hello");
        // Create user in database
        Optional<User> userOp = repository.findByUsername(user.getUsername());
        if (!userOp.isPresent()) {
            user = repository.save(user);
            return user;
        }

        throw new ResponseStatusException(HttpStatus.CONFLICT, "Account already exists");
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Long login(@RequestBody LoginForm form) {
        Optional<User> userOp = repository.findByUsername(form.getUsername());
        if (userOp.isPresent()) {
            User user = userOp.get();
            if (form.getPassword().equals(user.getPassword())) {
                return user.getId();
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect password");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unknown username");
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public boolean logout(@RequestBody User user) {
        return true;
    }
}
