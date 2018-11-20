package com.mockito.demo.service;

import com.mockito.demo.dao.UserMapper;
import com.mockito.demo.entity.User;
import com.mockito.demo.utils.DateUtils;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Boolean save(User user) {
        int row = userMapper.insert(user);
        return row > 0;
    }

}
