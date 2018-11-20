package com.mockito.demo.service;

import com.mockito.demo.entity.User;

import java.util.Date;

public interface UserService {

    User findById(Long userId);

    Boolean save(User user);
}
