package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.UserDto;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1.0/user/")
public class UserController {

    private final UserService userService;

    @Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public UserDto getUser() {
        return userService.getUser();
    }

    @PutMapping
    public UserDto putUser(@RequestBody User updatedUser) {
        User user = userService.getAuthenticatedUser();
        return userService.updateUser(user, updatedUser);
    }
}