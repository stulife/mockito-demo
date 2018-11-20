package com.mockito.demo.service;

import com.mockito.demo.DemoApplicationTests;
import com.mockito.demo.dao.UserMapper;
import com.mockito.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.anyLong;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    @InjectMocks//被注入mock对象的类一般是被测试类
    private UserServiceImpl userService;

    @Mock//需要mock的bean
    private UserMapper userMapper;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByIdTest() {
        User mockUser = new User();
        mockUser.setName("test");
        mockUser.setSex(1);
        mockUser.setId(2L);
//        Mockito.when(userMapper.selectByPrimaryKey(2L)).thenReturn(mockUser);
        Mockito.when(userMapper.selectByPrimaryKey(anyLong())).thenReturn(mockUser);
        User user = userService.findById(2L);
        log.info("user.name = {}", user.getName());
        Assert.assertEquals(user.getName(), "test");
    }

    @Test
    public void saveTest() {
        User user = new User();
        Mockito.when(userMapper.insert(user)).thenReturn(1);
        Boolean flag = userService.save(user);
        log.info("flag = {}", flag);
        Assert.assertEquals(flag, true);
    }



}
