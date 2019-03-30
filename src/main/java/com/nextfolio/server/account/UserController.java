package com.nextfolio.server.account;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class UserController {

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public User register(@RequestBody User user) {
        // Create user in database
        // Don't worry about plain text password
        return user;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void login(@RequestBody User user) {

    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public void logout(@RequestBody User user) {

    }
}
