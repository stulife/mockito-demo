package com.mockito.demo.controller;

import com.mockito.demo.entity.User;
import com.mockito.demo.service.UserService;
import com.mockito.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public Result getUser() {
        return Result.success(this.userService.findById(1L));
    }
    @PostMapping("/user")
    public Result save(@RequestBody User user) {
        this.userService.save(user);
        return Result.success();
    }
}
