package com.mockito.demo.service;

import com.mockito.demo.entity.User;
import com.mockito.demo.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DateUtils.class,TestServiceImpl.class, User.class,ClassA.class})
@SpringBootTest
@Slf4j
public class TestServiceTest {
    @Autowired
    @InjectMocks//被注入mock对象的类一般是被测试类
    private TestServiceImpl testService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void callStaticMethodTest() {
        Date date = new Date();
        PowerMockito.mockStatic(DateUtils.class);
        PowerMockito.when(DateUtils.getMonth(date)).thenReturn(1);
        int month = testService.callStaticMethod(date);
        log.info("month = {}", month);
        Assert.assertEquals(month, 4);
    }

    @Test
    public void callPrivateMethodTest() throws Exception {
        Date date = new Date();
        TestServiceImpl underTest = PowerMockito.mock(TestServiceImpl.class);
        PowerMockito.when(underTest.callPrivateMethod(date)).thenCallRealMethod();
        PowerMockito.when(underTest, "getMonth",date).thenReturn(1);
        Assert.assertEquals(underTest.callPrivateMethod(date), 4);
    }

    @Test
    public void callVoidTest() {
        // 模拟 不执行void的方法
        TestServiceImpl underTest = PowerMockito.spy(new TestServiceImpl());
        PowerMockito.doNothing().when(underTest).callVoid();
        underTest.callVoid();
    }


    @Test
    public void callFinalTest() {
        ClassA a = PowerMockito.mock(ClassA.class);
        PowerMockito.when(a.isAlive()).thenReturn(true);
        Boolean expected = testService.callFinalMethod(a);
        Assert.assertEquals(expected, true);
    }

    @Test
    public void callInternalInstanceTest() throws Exception {
        User mockUser = new User();
        mockUser.setName("mock");
        PowerMockito.whenNew(User.class).withNoArguments().thenReturn(mockUser);
        String expected= testService.callInternalInstance();
        Assert.assertEquals(expected, mockUser.getName());
    }


}
