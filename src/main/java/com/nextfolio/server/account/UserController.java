package com.nextfolio.server.account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class UserController {

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public User register(@RequestParam(value = "username") String username,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "email") String email) {
        // Create user in database
        // Don't worry about plain text password
        User user = new User(username, password);
        return user;
    }
}
