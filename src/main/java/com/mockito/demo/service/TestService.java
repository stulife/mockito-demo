package com.mockito.demo.service;

import com.mockito.demo.entity.User;

import java.util.Date;

public interface TestService {


    /**
     * Mock static
     * @param date
     * @return 当前月份 加 3
     */
    int callStaticMethod(Date date);


    /**
     * Mock private
     * @param date
     * @return 当前月份 加 3
     */
    int callPrivateMethod(Date date);

    /**
     * Mock void
     */
    void  callVoid();

    /**
     * Mock方法内部new出来的对象
     * @return
     */
    String callInternalInstance();

}
